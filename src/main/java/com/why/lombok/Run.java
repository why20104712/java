package com.why.lombok;


/**
 * 测试lombok
 * @author wanghaiyang
 * @date 26/01/2018 09:17
 */
public class Run {


    public static void main(String[] args) {
        Girl girl = new Girl();

        girl.setAge(1);
        girl.setName("aaa");
        girl.setSex(1);


        System.out.println(girl);
    }

}
