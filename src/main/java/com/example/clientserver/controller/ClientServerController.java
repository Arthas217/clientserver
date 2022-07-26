package com.example.clientserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 会游泳的蚂蚁
 * @Description:
 * @Date 2022/7/26 17:29
 */
@RestController
public class ClientServerController {

    @RequestMapping("/m1")
    public void method1(@RequestParam(value = "token") String token) {
        System.out.println("111111---" + token);
    }
    // 一、 @RequestMapping 支持get
    //  required = true 默认
    //  1、不传参数token
    //  -浏览器请求  Whitelabel Error Page This application has no explicit mapping for /error, so you are seeing this as a fallback.
    //  -postman请求
    //  请求响应：{"timestamp":"2022-07-26T09:49:56.661+00:00","status":400,"error":"Bad Request","path":"/m1"}
    //  后端报错org.springframework.web.bind.MissingServletRequestParameterException: request parameter 'token' for method parameter type String is not present]
    //  2、传参数token
    //  -浏览器success
    //  -postman请求 请求参数类型 QueryParams、  Content-Type为multipart/form-data; boundary=<calculated when request is sent>   token值为1 success

    // 二、 @RequestMapping 支持post（Content-Type为application/x-www-form-urlencoded 和form-data ）
    // 1、不传参数token
    // -postman请求 {"timestamp":"2022-07-26T09:49:56.661+00:00","status":400,"error":"Bad Request","path":"/m1"}
    // 2、传参数token
    // -postman请求
    //  Content-Type为application/x-www-form-urlencoded 和form-data   success
    //  Content-Type为application/json
    //  请求响应：{"timestamp":"2022-07-26T09:49:56.661+00:00","status":400,"error":"Bad Request","path":"/m1"}
    //  后端报错org.springframework.web.bind.MissingServletRequestParameterException: request parameter 'token' for method parameter type String is not present]



}
