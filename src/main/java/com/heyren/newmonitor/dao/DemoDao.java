package com.heyren.newmonitor.dao;

import com.heyren.newmonitor.entity.DemoUser;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DemoDao {
    private List<DemoUser> userDemoList = new ArrayList<>();
    public void save(DemoUser user){
        userDemoList.add(user);
    }
    public List<DemoUser> findAll(){
        return userDemoList;
    }
}
