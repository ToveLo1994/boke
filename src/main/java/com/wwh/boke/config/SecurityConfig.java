package com.wwh.boke.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
* @Description:    Spring Security 路径权限配置
* @Author:         wangwenhu
* @CreateDate:     2020/9/25 0025 16:04
* @UpdateUser:     修改人 修改时更新
* @UpdateDate:     2020/9/25 0025 16:04
* @UpdateRemark:   修改内容 修改时更新
* @Version:        1.0
*/
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                // 完全可以访问与/ css / **和/ index匹配的请求
                .antMatchers("/css/**", "/index").permitAll()
                // 与/ user / **匹配的请求要求对用户进行身份验证，并且必须将其与USER角色相关联
                .antMatchers("/user/**").hasRole("USER")
                .and()
                .formLogin()
                // 通过自定义登录页面和失败URL启用基于表单的身份验证
                .loginPage("/login").failureUrl("/login-error");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
    }
}
