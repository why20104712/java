package com.why.bean;

/**
 * 服务类，使用spring的java配置方式初始化bean
 */
public class MyService<T> {


    public void service() {
        System.out.printf("my service");
    }

}
