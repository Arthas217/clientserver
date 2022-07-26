package com.example.clientserver.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author 会游泳的蚂蚁
 * @Description: https://blog.csdn.net/wphero/article/details/108260313
 * https://blog.csdn.net/zhanglf02/article/details/78470219
 * @Date 2022/7/26 17:29
 */
@RestController
public class ClientServerController {

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

    @RequestMapping("/m1")
    public void method1(@RequestParam(value = "token") String token) {
        System.out.println("111111---" + token);
    }

    // 二、@RequestBody  接收的参数是来自requestBody中，即请求体
    // 1、get请求
    // -浏览器请求   失败org.springframework.http.converter.HttpMessageNotReadableException: Required request body is missing: public void com.example.clientserver.controller.ClientServerController.method3(java.lang.String)]
    // -postman请求  Content-Type为application/x-www-form-urlencoded   success
    //  Content-Type为application/json   后端直接返回 222222---{"token":"2"}

    // 2、post请求
    // -postman请求  Content-Type为application/x-www-form-urlencoded   success

    @RequestMapping("/m2")
    public void method2(@RequestBody String token) {
        System.out.println("222222---" + token);
    }


    // 三、 @ResponseBody  结果Response对象的body数据区
    // 当你不加上@ResponseBody，返回到页面的是String类型的数据。加上这个注解，获取到的就是json格式的

    @RequestMapping("/m3")
    @ResponseBody
    public JSONObject method3(@RequestBody JSONObject token) {
        return token;
    }

    //HttpServletRequest方式
    // 1、get请求
    // 浏览器请求  http://localhost:8080/m4   返回结果 {"requestMethod":"GET"}
    // postman请求   请求body {"requestMethod":"GET"}

    // 2、post请求
    // postman请求   请求body {"requestMethod":"POST"}

    @RequestMapping("/m4")
    @ResponseBody
    public Map<String, Object> method4(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>(1);
        String method = request.getMethod();
        map.put("requestMethod", method);
        return map;
    }

}
