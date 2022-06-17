package com.heyren.newmonitor.controller;

import com.heyren.newmonitor.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    JdbcTemplate jdbcTemplate;



    @RequestMapping(path = "/get",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> map(){
        List<Map<String,Object>> list = jdbcTemplate.queryForList("SELECT * from user");
        System.out.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        return list.get(0);
    }

}
