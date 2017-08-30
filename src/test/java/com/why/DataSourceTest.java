package com.why;

import com.why.bean.User;
import com.why.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/applicationContext.xml"})
public class DataSourceTest {


    @Resource
    private UserService userService;

    @Test
    public void test() {
        User user = userService.getEntity(1);
        System.out.println(user.getName());
    }
}
