package com.why;

/**
 * 函数式接口
 * 1、在接口中只有一个抽象方法
 * 2、使用注解限制@FunctionalInterface
 *
 * 在函数式接口中，可以有别的非抽象方法和object自带的方法
 * 1、static
 * 2、default
 * 3、Object对象的方法
 * Created by why on 13/07/2017.
 */
@FunctionalInterface
public interface FunctionalInterfaceDemo {

    void test();

    static void test1() {
        System.out.println("test1");
    }
    static void test12() {
        System.out.println("test1");
    }

    default void test2() {
        System.out.println("test2");
    }

    /**
     * Object类的方法，所有类和接口都可以实现，覆盖这个方法
     * @param obj 对象
     * @return boolean
     */
    @Override
    boolean equals(Object obj);
}
