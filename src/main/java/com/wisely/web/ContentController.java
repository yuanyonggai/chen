package com.wisely.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wisely.domain.DemoObj;

@Controller
public class ContentController {
    @RequestMapping(value = "/getdemo",method = RequestMethod.GET)
    public String getDemo(Model model){
        DemoObj demoObj = new DemoObj(333l, "WYF");
        model.addAttribute("demoObj",demoObj);
        return "demoObj";

    }

}