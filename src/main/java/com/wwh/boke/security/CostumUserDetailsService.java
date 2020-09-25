package com.wwh.boke.security;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wwh.boke.entity.BlogUser;
import com.wwh.boke.service.BlogUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @Description:    Spring security 用于将用户信息和权限注入
* @Author:         wangwenhu
* @CreateDate:     2020/9/25 0025 17:03
* @UpdateUser:     修改人 修改时更新
* @UpdateDate:     2020/9/25 0025 17:03
* @UpdateRemark:   修改内容 修改时更新
* @Version:        1.0
*/
@Service("userDetailsService")
public class CostumUserDetailsService implements UserDetailsService {

    @Autowired
    private BlogUserService blogUserService;

    @Override
    public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException{
        //从数据库中取出user
        BlogUser blogUser = blogUserService.getOne(new LambdaQueryWrapper<BlogUser>().eq(BlogUser::getUserName, username));
        //判断用户是否存在
        if (blogUser == null) {
            throw  new UsernameNotFoundException("用户名不存在");
        }
        //添加权限
        List<GrantedAuthority> authoritys = new ArrayList<>();
        if (blogUser.getRole() == 0){
            authoritys.add(new SimpleGrantedAuthority("ROLE_USER"));
        } else {
            authoritys.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        //返回实体类
        return new User(blogUser.getUserName(), blogUser.getPassword(),authoritys);

    }

}
