package com.why;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

//        例1、用lambda表达式实现Runnable

        /**
         * 因为Runnable接口是函数式接口，所以可以使用lamada表达式
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("test1");
            }
        }).start();

// Java 8之后：
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


//        例2、使用Java 8 lambda表达式进行事件处理
        // Java 8之前：
        JButton show = new JButton("Show");
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Event handling without lambda expression is boring");
            }
        });
// Java 8之后：
        show.addActionListener(e -> System.out.println("Event handling without lambda expression is boring"));

//        例3、使用lambda表达式对列表进行迭代

        // Java 8之前：
        List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        for (String feature : features) {
            System.out.println(feature);
        }

        // Java 8之后：
        features.forEach(t -> {
            System.out.println(t);
        });

        // 使用Java 8的方法引用更方便，方法引用由::双冒号操作符标示，
// 看起来像C++的作用域解析运算符
        features.forEach(System.out::println);

//        例4、使用lambda表达式和函数式接口Predicate
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

        System.out.println("Languages which starts with J :");
        filter(languages, (str) -> str.startsWith("J"));

        System.out.println("Languages which ends with a ");
        filter(languages, (str) -> str.endsWith("a"));

        System.out.println("Print all languages :");
        filter(languages, (str) -> true);

        System.out.println("Print no language : ");
        filter(languages, (str) -> false);

        System.out.println("Print language whose length greater than 4:");
        filter(languages, (str) -> str.length() > 4);


//        例5、如何在lambda表达式中加入Predicate


//        例6、Java 8中使用lambda表达式的Map和Reduce示例
        // 不使用lambda表达式为每个订单加上12%的税
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        for (Integer cost : costBeforeTax) {
            double price = cost + .12 * cost;
            System.out.println(price);
        }

        // 使用lambda表达式
        costBeforeTax.stream().map((cost) -> cost + .12 * cost).forEach(System.out::println);


//        例7、通过过滤创建一个String列表
// 创建一个字符串列表，每个字符串长度大于2
        List<String> strList = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
        List<String> filtered = strList.stream().filter(x -> x.length()> 2).collect(Collectors.toList());
        System.out.printf("Original List : %s, filtered list : %s %n", strList, filtered);


//        例8、对列表的每个元素应用函数
        // 将字符串换成大写并用逗号链接起来
        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");
        String G7Countries = G7.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", "));
        System.out.println(G7Countries);


//        例9、复制不同的值，创建一个子列表
//        本例展示了如何利用流的 distinct() 方法来对集合进行去重。

        // 用所有不同的数字创建一个正方形列表
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
        System.out.printf("Original List : %s,  Square Without duplicates : %s %n", numbers, distinct);


//        例10、计算集合元素的最大值、最小值、总和以及平均值
        //获取数字的个数、最小值、最大值、总和以及平均值
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntStream intStream = primes.stream().mapToInt((x) -> x);
        IntSummaryStatistics stats = intStream.summaryStatistics();
        System.out.println("Highest prime number in List : " + stats.getMax());
        System.out.println("Lowest prime number in List : " + stats.getMin());
        System.out.println("Sum of all prime numbers : " + stats.getSum());
        System.out.println("Average of all prime numbers : " + stats.getAverage());

    }


//    public static void filter(List<String> names, Predicate<String> condition) {
//        for (String name : names) {
//            if (condition.test(name)) {
//                System.out.println(name + " ");
//            }
//        }
//    }

//    public static void filter(List<String> names, Predicate<String> condition) {
//
//        names.forEach(name ->{if (condition.test(name)) {
//            System.out.println(name + " ");
//        }});
//    }

    public static void filter(List<String> names, Predicate<String> condition) {

        names.forEach(name -> {
            if (condition.test(name)) {
                System.out.println(name + " ");
            }
        });


        names.stream().filter(name -> {
            if (condition.test(name)) {
                System.out.println(name + " ");
                return true;
            } else {
                return false;
            }
        });

        names.stream().filter((name) -> (condition.test(name))).forEach((name) -> {
            System.out.println(name + " ");
        });

        // 甚至可以用and()、or()和xor()逻辑函数来合并Predicate，
// 例如要找到所有以J开始，长度为四个字母的名字，你可以合并两个Predicate并传入
        Predicate<String> startsWithJ = (n) -> n.startsWith("J");
        Predicate<String> fourLetterLong = (n) -> n.length() == 4;
        names.stream()
                .filter(startsWithJ.and(fourLetterLong))
                .forEach((n) -> System.out.print("nName, which starts with 'J' and four letter long is : " + n));





    }

}
