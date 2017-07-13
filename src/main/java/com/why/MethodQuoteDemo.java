package com.why;

/**
 * 方法引用
 * 1、引用静态方法String::valueOf
 * 2、引用对象的实例方法x::toString
 * 3、引用某个类型的任意对象的实例方法String::toString
 * 4、引用构造函数String::new
 * Created by why on 13/07/2017.
 */
public class MethodQuoteDemo {

    public static void main(String[] args) {

        /**
         * 引用构造函数PersonInfo::new
         */
        PersonInfoFactory personInfoFactory = new PersonInfoFactory(PersonInfo::new);
    }
}
