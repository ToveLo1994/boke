package com.wwh.boke.controller;

import com.wwh.boke.entity.vo.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//声明为异常处理器
@RestControllerAdvice
public class ExceptionController {

    // 捕获 RuntimeException 的异常
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity handleException(RuntimeException e) {
        return new ResponseEntity(HttpStatus.BAD_REQUEST.value(), e.getMessage(), null);
    }

}
