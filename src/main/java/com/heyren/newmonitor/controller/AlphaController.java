package com.heyren.newmonitor.controller;

import com.heyren.newmonitor.Service.AlphaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AlphaController {
    @Autowired
    AlphaService alphaService;
    @RequestMapping("/alpha")
    @ResponseBody
    public String alpha(){
        return "alpha";
    }
}
