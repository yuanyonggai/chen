package com.wisely.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdviceController {
    @RequestMapping("/advice")
    public String getSomething(){
        throw new IllegalArgumentException("不好意思,参数错了");
    }

}