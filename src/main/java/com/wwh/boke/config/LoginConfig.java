package com.wwh.boke.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;

@Configuration
public class LoginConfig {

    @Bean("SessionStrategy")
    public SessionStrategy regisBean(){
        SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();
        return  sessionStrategy;
    }

}
