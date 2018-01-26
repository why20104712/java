package com.why;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilteringApples {


    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80,"green"), new Apple(155, "green"), new Apple(120, "red"));


        filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getWeight() > 180;
            }
        });

        //第六版
        filterApples(inventory, (Apple apple) -> apple.getWeight() > 100);



        //遍历输出
        inventory.forEach((Apple apple) -> System.out.println(apple));

    }



    /**
     * 根据任意对象的属性进行筛选
     */
    public interface Predicate<T>{
        boolean test(T t);
    }


    /**
     * 根据抽象条件筛选(第五版)
     */
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate appleApplePredicate) {
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple : inventory) {
            if (appleApplePredicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }


    /**
     * 根据apple的属性进行筛选
     */
    public interface ApplePredicate{
        boolean test(Apple apple);
    }

    /**
     * 过滤绿色苹果
     */
    public static class AppleGreenColorPredicate implements ApplePredicate {

        @Override
        public boolean test(Apple apple) {
            return "green".equals(apple.getColor());
        }
    }


    /**
     * 根据重量大于150筛选苹果
     */
    public static class AppleHeavyWeightPredicate implements ApplePredicate{

        @Override
        public boolean test(Apple apple) {
            return apple.getWeight() > 150;
        }
    }



    /**
     * 对你能想到的每个属性做筛选（第四版）
     */
    public static List<Apple> filterApples(List<Apple> inventory, String color, int weight, boolean flag) {
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple : inventory) {
            if ((flag && apple.getColor().equals(color)) || (!flag && apple.getWeight() > weight)) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 从列表中按照重量筛选苹果的功能(第三版)
     */
    public static List<Apple> filterApplesByWeight(List<Apple> inventory, String weight) {
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple : inventory) {
            if (weight.equals(apple.getWeight())) {
                result.add(apple);
            }
        }
        return result;
    }


    /**
     * 从列表中按照颜色筛选苹果的功能(第二版)
     */
    public static List<Apple> filterApplesByColor(List<Apple> inventory, String color) {
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple : inventory) {
            if (color.equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }


    /**
     * 从列表中筛选绿苹果的功能(第一版)
     */
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple : inventory) {
            if ("green".equals(apple.getColor())) {
                result.add(apple); //仅仅选出绿苹果
            }
        }
        return result;
    }


    public static class Apple {
        private int weight = 0;
        private String color = "";

        public Apple(int weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String toString() {
            return "Apple{" +
                    "color='" + color + '\'' +
                    ", weight=" + weight +
                    '}';
        }
    }
}
