package com.heyren.newmonitor;

import com.heyren.newmonitor.configuration.RedisConfig;
import com.heyren.newmonitor.entity.User;
import com.heyren.newmonitor.repository.UserRedis;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RedisConfig.class, UserRedis.class})
public class RedisTest {
    private static Logger logger = LoggerFactory.getLogger(RedisTest.class);
    @Autowired
    UserRedis userRedis;
    @Before
    public void setup(){
        User user = new User();
        user.setUsername("user");
        user.setCreateTime(new Date());
        userRedis.delete(this.getClass().getName()+"userByname"+user.getUsername());
        userRedis.add(this.getClass().getName()+"userByname"+user.getUsername(),10L,user);
    }

    @Test
    public void get(){
        User user = userRedis.get(this.getClass().getName()+"userByname:user");
        Assert.notNull(user);
        logger.info("============user==========name:{}",user.getUsername());
    }

}
