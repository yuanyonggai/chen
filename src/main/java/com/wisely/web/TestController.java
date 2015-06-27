package com.wisely.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //声明为控制器bean
@RequestMapping("/test")// 根地址为http://localhost:8080/testSpringMVC/test
public class TestController {
    //response媒体类型(MediaType)为text/plain,编码是utf-8
    @RequestMapping(produces = "text/plain;charset=UTF-8")
    //映射地址为http://localhost:8080/testSpringMVC/test
    @ResponseBody //此注解让返回值不是页面,也是将结果字符串直接返回
    public  String root(HttpServletRequest request){
        return "url:"+request.getRequestURL()+" 可以访问此方法";
    }

    @RequestMapping(value = "/add",produces = "text/plain;charset=UTF-8")
    //映射地址为http://localhost:8080/testSpringMVC/test/add
    @ResponseBody
    public   String add(HttpServletRequest request){
        return "url:"+request.getRequestURL()+" 可以访问此方法";
    }

    @RequestMapping(value = {"/remove","/delete"},produces = "text/plain;charset=UTF-8")
    //映射地址为http://.../test/remove(或http://.../test/delete)
    @ResponseBody
    public   String remove(HttpServletRequest request){
        return "url:"+request.getRequestURL()+" 可以访问此方法";
    }

    //获取request参数
    //获取路径参数
    @RequestMapping(value = "/get",produces = "text/plain;charset=UTF-8")
    //映射路径http://.../test/get?id=123
    @ResponseBody
    public String passRequestParam(@RequestParam Long id,HttpServletRequest request){
        System.out.println("id为"+id);
        return "url:"+request.getRequestURL()+" 可以访问此方法";

    }


    //获取路径参数
    @RequestMapping(value = "/{id}",produces = "text/plain;charset=UTF-8")
    //映射路径http://.../test/123
    @ResponseBody
    public String passPathVariable(@PathVariable Long id,HttpServletRequest request){
        System.out.println("id为"+id);
        return "url:"+request.getRequestURL()+" 可以访问此方法";

    }

    //获得对象
    @RequestMapping(value = "/pass",produces = "text/plain;charset=UTF-8")
    //映射路径http://.../test/pass?id=123&name=wyf
    @ResponseBody
    public String passObj(DemoObj obj,HttpServletRequest request){
        System.out.println("对象的id和名称分别为为："+obj.getId()+"/"+obj.getName());
        return "url:"+request.getRequestURL()+" 可以访问此方法";

    }




}