package com.why;

import com.why.bean.MyService;
import com.why.config.AppConfig;
import com.why.service.FunctionalInterfaceDemo;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.Resource;

/**
 * 测试函数式接口
 * Created by why on 13/07/2017.
 */
@SpringBootTest
public class FunctionInterfaceDemoTest {


    private static ApplicationContext applicationContext;

    private static MyService myService;

    static {
        applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        myService = (MyService)applicationContext.getBean("myService");
    }

    @Test
    public void test() {
        FunctionalInterfaceDemo functionalInterfaceDemo = new FunctionalInterfaceDemo() {
            @Override
            public void test() {
                System.out.println("test");
            }
        };

        functionalInterfaceDemo.test();
        FunctionalInterfaceDemo.test1();

        functionalInterfaceDemo.test2();
    }

    @Test
    public void myServiceTest() {
        myService.service();
    }

}
