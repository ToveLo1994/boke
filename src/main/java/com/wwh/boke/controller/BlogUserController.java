package com.wwh.boke.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author wwh
 * @since 2020-09-25
 */
@RestController
@RequestMapping("/blog-user")
public class BlogUserController {

        @GetMapping
        public String getUsers(){
            return "hello , spring security";
        }

}

