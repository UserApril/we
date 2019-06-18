package com.zz.we.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
@Controller
public class ViewController {

    @RequestMapping("/{value}")
    public String getIndex(@PathVariable("value") String value){
        return value+".html";
    }
}
