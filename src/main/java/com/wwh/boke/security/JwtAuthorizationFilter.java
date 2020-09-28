package com.wwh.boke.security;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wwh.boke.entity.BlogUser;
import com.wwh.boke.service.BlogUserService;
import com.wwh.boke.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.util.Assert;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    @Autowired
    private BlogUserService blogUserService;

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        //判断是否有token,并且认证
        Authentication token = getAuthentication(request);
        //认证失败
        if (token == null) {
            chain.doFilter(request,response);
            return;
        }
        //认证成功,把Token放入SecurityContextHolder
        SecurityContextHolder.getContext().setAuthentication(token);
        chain.doFilter(request,response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request){
        // 获取 header 中的 Authorization 字段
        String header = request.getHeader("Authorization");
        if (header == null || ! header.startsWith("Bearer ")) {
            return null;
        }

        // 拿到 Bearer 后面跟着的 token
        String token = header.split(" ")[1];
        // 通过 token 获取当前用户的用户名
        String username = JwtUtil.getUsername(token);
        UserDetails userDetails = null;
        try {
            // 数据库查询此用户的信息
            BlogUser blogUser = blogUserService.getOne(new LambdaQueryWrapper<BlogUser>().eq(BlogUser::getUserName, username));
            Assert.notNull(blogUser,"用户不存在");
            //添加权限
            List<GrantedAuthority> authoritys = new ArrayList<>();
            if (blogUser.getRole() == 0){
                authoritys.add(new SimpleGrantedAuthority("ROLE_USER"));
            } else {
                authoritys.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            }
            userDetails = new User(blogUser.getUserName(),blogUser.getPassword(),authoritys);
        } catch (Exception e) {
            return null;
        }
        // 校验 token
        if (! JwtUtil.verify(token, username, userDetails.getPassword())) {
            return null;
        }

        // Token 合法，这里返回 Security 的 UsernamePasswordAuthenticationToken，这里包含了用户的信息与权限
        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }

}
