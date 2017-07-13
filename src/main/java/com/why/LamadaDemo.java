package com.why;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * lamada表达式
 * 语法组成：
 * 1、（）中以逗号分隔的形式参数，参数是函数式接口中的方法入参
 * 2、一个箭头->
 * 3、方法体或者代码块
 * {parameter}->express | {}
 * Created by why on 13/07/2017.
 */
public class LamadaDemo {

    public static void main(String[] args) {


        /**
         * 因为Runnable接口是函数式接口，所以可以使用lamada表达式
         */

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("test1");
            }
        }).start();


        new Thread(() -> System.out.println("test2")).start();


        new Thread(() -> {
            System.out.println("test3");
        }).start();


        List<String> list = Arrays.asList(new String[]{"a", "b", "c"});
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });


        list.sort((String o1, String o2) -> {
            return o2.compareTo(o1);
        });

        list.sort((o1, o2) -> {
            return o2.compareTo(o1);
        });

        list.sort((o1, o2) -> o2.compareTo(o1));

        for (String s : list) {
            System.out.println(s);
        }




    }
}
