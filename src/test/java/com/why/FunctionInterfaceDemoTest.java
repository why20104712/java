package com.why;

/**
 * 测试函数式接口
 * Created by why on 13/07/2017.
 */
public class FunctionInterfaceDemoTest {

    public static void main(String[] args) {
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
}
