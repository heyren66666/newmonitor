package com.heyren.newmonitor.controller;

import com.heyren.newmonitor.Service.DemoService;
import com.heyren.newmonitor.entity.DemoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class DemoController {
    @Autowired
    private DemoService demoService;
    @RequestMapping("add")
    public DemoUser add(DemoUser user){
        demoService.addUser(user);
        return user;
    }
    @GetMapping("list")
    public List<DemoUser> list(){
       return demoService.list();
    }
}
