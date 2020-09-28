package com.wwh.boke.config;

import com.wwh.boke.security.CostumUserDetailsService;
import com.wwh.boke.security.JwtAuthenticationFilter;
import com.wwh.boke.security.JwtAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
* @Description:    Spring Security 路径权限配置
* @Author:         wangwenhu
* @CreateDate:     2020/9/25 0025 16:04
* @UpdateUser:     修改人 修改时更新
* @UpdateDate:     2020/9/25 0025 16:04
* @UpdateRemark:   修改内容 修改时更新
* @Version:        1.0
*/
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     *  注入自定义的userDetailsService
     */
    @Autowired
    private CostumUserDetailsService userDetailsService;

    /**
     * 注册一个bean，指定密码的加密模式。
    * */
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilter(new JwtAuthenticationFilter(authenticationManager()))
                .formLogin() 								    // 定义当需要用户登录时候，转到的登录页面。
                .loginPage("/login")	 					// 设置登录页面
                .loginProcessingUrl("/user/login") 			// 自定义的登录接口

                //.addFilter(new JwtAuthorizationFilter(authenticationManager(), userDetailsService))
                //.defaultSuccessUrl("/home").permitAll()		// 登录成功之后，默认跳转的页面
                // 前后端分离是 STATELESS，故 session 使用该策略

                .and().authorizeRequests()					// 定义哪些URL需要被保护、哪些不需要被保护
                .antMatchers("/", "/index","/user/login").permitAll()		// 设置所有人都可以访问登录页面
                .anyRequest().authenticated() 				// 任何请求,登录后可以访问
                .and().csrf().disable(); 					// 关闭csrf防护

        /*http
                .authorizeRequests()
                // 完全可以访问与/ css / **和/ index匹配的请求
                .antMatchers("/css/**", "/index").permitAll()
                // 与/ user / **匹配的请求要求对用户进行身份验证，并且必须将其与USER角色相关联
                .antMatchers("/user/**").hasRole("USER")
                .and()
                .formLogin()
                // 通过自定义登录页面和失败URL启用基于表单的身份验证
                .loginPage("/login").failureUrl("/login-error");*/
    }

    /**
     * 配置自定义的userDetailsService来进行用户认证和权限授权
     * 配置使用BCrypt加密方式加密密码
     * */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoder());
    }

    /**
     * 忽略静态资源获取，获取静态资源不需要权限
     *
     * */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/webjars/**/*", "/**/*.css", "/**/*.js");
    }

}

