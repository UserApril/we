package com.zz.we.controller;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/operator")
@RestController
public class BackController {


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Object login(@RequestParam("account") String account,@RequestParam("password") String password,@RequestParam("verifyCode") String verifyCode){

        return null;
    }

}
