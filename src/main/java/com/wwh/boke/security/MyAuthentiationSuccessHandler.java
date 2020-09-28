package com.wwh.boke.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

/**
* @Description:    自定义登录成功处理类，添加JWT到用户返回信息中。
* @Author:         wangwenhu
* @CreateDate:     2020/9/27 0027 14:22
* @UpdateUser:     修改人 修改时更新
* @UpdateDate:     2020/9/27 0027 14:22
* @UpdateRemark:   修改内容 修改时更新
* @Version:        1.0
*/
@Slf4j
@Component("myAuthenctiationSuccessHandler")
public class MyAuthentiationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        log.info("登录成功");
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(objectMapper.writeValueAsString(authentication));
    }
}