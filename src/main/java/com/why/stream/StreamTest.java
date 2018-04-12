package com.why.stream;

import com.why.bean.Person;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) {


        List<Integer> integerList = Arrays.asList(1, 2, 3);

        List<String> collect = integerList.stream().map(a -> a.toString()).collect(Collectors.toList());
        collect.forEach(System.out::println);





    }
}
