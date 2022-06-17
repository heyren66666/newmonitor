package com.heyren.newmonitor;

import com.heyren.newmonitor.configuration.JpaConfiguration;
import com.heyren.newmonitor.entity.User;
import com.heyren.newmonitor.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JpaConfiguration.class})
public class MySqlTest {
    private static Logger logger = LoggerFactory.getLogger(MySqlTest.class);

    @Autowired
    UserRepository userRepository;

    @Before
    public void init(){
        userRepository.deleteAll();
        User user = new User();
        user.setUsername("user");
        Assert.assertNotNull(user.getId());
    }
    @Test
    public void findPage(){
        Pageable pageable = PageRequest.of(0,10,Sort.by(Sort.Direction.ASC,"id"));
        Page<User> page = userRepository.findAll(pageable);
        Assert.assertNotNull(page);
        for (User user:page.getContent()){
            logger.info("=====user=====user name{}",user.getUsername());
        }
    }
}
