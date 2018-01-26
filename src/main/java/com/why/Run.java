package com.why;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.IntPredicate;

public class Run {

    public static void main(String[] args) {
        IntPredicate evenNumbers = (int i) -> i % 2 == 0;

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(4);
        list.add(5);

//        list.removeIf((item) -> item % 2 == 0);
        Comparator<Integer> comparator = Comparator.comparing(Integer::intValue);



        list.sort(Comparator.comparing(Integer::intValue));
        list.forEach((Integer item) -> {
            System.out.println(item);
        });


//        Arrays.asList(1, 2, 2);


        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        list.sort((a,b) -> a-b);

    }
}
