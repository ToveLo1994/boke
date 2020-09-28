package com.wwh.boke.security;


import org.springframework.security.core.AuthenticationException;

public class MyAuthenctiationFailureHandler extends AuthenticationException{
    private static final long serialVersionUID = 1L;

    public MyException(String msg) {
        super(msg);
    }
}
