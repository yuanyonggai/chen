package com.wisely.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(value=Exception.class)
    public ModelAndView exception(Exception exception,WebRequest request){
        ModelAndView modelAndView = new ModelAndView("error");//error页面
        modelAndView.addObject("errorMessage",exception.getMessage());
        return modelAndView;

    }
}