package com.wwh.boke.controller;

import com.wwh.boke.entity.vo.ResponseEntity;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @Description:    定义一个全局异常类
* @Author:         wangwenhu
* @CreateDate:     2020/9/28 0028 15:14
* @UpdateUser:     修改人 修改时更新
* @UpdateDate:     2020/9/28 0028 15:14
* @UpdateRemark:   修改内容 修改时更新
* @Version:        1.0
*/
@ApiIgnore
@RestController
public class CustomErrorController implements ErrorController {

    @Override
    public String getErrorPath(){
        return "/error";
    }

    @RequestMapping("/error")
    public ResponseEntity handleError(HttpServletRequest request, HttpServletResponse response){
        return new ResponseEntity(response.getStatus(),
                (String) request.getAttribute("javax.servlet.error.message"), null);
    }


}
