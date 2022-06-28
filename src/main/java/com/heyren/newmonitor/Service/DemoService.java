package com.heyren.newmonitor.Service;

import com.heyren.newmonitor.dao.DemoDao;
import com.heyren.newmonitor.entity.DemoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoService {
    @Autowired
    private DemoDao demoDao;

    public void addUser(DemoUser user){
        demoDao.save(user);
    }

    public List<DemoUser> list(){
       return demoDao.findAll();
    }
}
