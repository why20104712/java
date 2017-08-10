package com.why.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 方法引用
 * 1、引用静态方法String::valueOf
 * 2、引用对象的实例方法x::toString
 * 3、引用某个类型的任意对象的实例方法String::toString
 * 4、引用构造函数String::new
 * <p>
 * <p>
 * 第一种方法引用的类型是构造器引用，语法是Class::new，或者更一般的形式：Class<T>::new。注意：这个构造器没有参数。
 * final Car car = Car.create( Car::new );
 * final List< Car > cars = Arrays.asList( car );
 * <p>
 * 第二种方法引用的类型是静态方法引用，语法是Class::static_method。注意：这个方法接受一个Car类型的参数。
 * cars.forEach( Car::collide );
 * <p>
 * 第三种方法引用的类型是某个类的成员方法的引用，语法是Class::method，注意，这个方法没有定义入参：
 * cars.forEach( Car::repair );
 * <p>
 * 第四种方法引用的类型是某个实例对象的成员方法的引用，语法是instance::method。注意：这个方法接受一个Car类型的参数：
 * final Car police = Car.create( Car::new );
 * cars.forEach( police::follow );
 * <p>
 * Created by why on 13/07/2017.
 */
public class MethodQuoteDemo {

    public static void main(String[] args) {

        /**
         * 引用构造函数PersonInfo::new
         */
        PersonInfoFactory personInfoFactory = new PersonInfoFactory(PersonInfo::new);


        List<PersonInfo> personInfoList = new ArrayList<>();

        PersonInfo personInfo1 = personInfoFactory.getPersonInfo();
        personInfo1.setName("a");

        personInfoList.add(personInfo1);

        PersonInfo personInfo2 = personInfoFactory.getPersonInfo();
        personInfo2.setName("b");

        personInfoList.add(personInfo2);


        PersonInfo personInfo3 = personInfoFactory.getPersonInfo();
        personInfo3.setName("c");

        personInfoList.add(personInfo3);


        /**
         * 引用对象的实例方法x::toString
         */
        personInfoList.sort(personInfo1::compareTo);
        print(personInfoList);


        /**
         * 引用某个类型的任意对象的实例方法String
         */
        personInfoList.sort(PersonInfo::compareTo);
        print(personInfoList);


        /**
         * 引用静态方法String::valueOf
         */
        personInfoList.sort(PersonInfo::compare);
        print(personInfoList);


//        第一种方法引用的类型是构造器引用，语法是Class::new，或者更一般的形式：Class<T>::new。注意：这个构造器没有参数。
        final Car car = Car.create(Car::new);
        final List<Car> cars = Arrays.asList(car);
//        第二种方法引用的类型是静态方法引用，语法是Class::static_method。注意：这个方法接受一个Car类型的参数。
        cars.forEach(Car::collide);
//        第三种方法引用的类型是某个类的成员方法的引用，语法是Class::method，注意，这个方法没有定义入参：
        cars.forEach(Car::repair);
//        第四种方法引用的类型是某个实例对象的成员方法的引用，语法是instance::method。注意：这个方法接受一个Car类型的参数：
        final Car police = Car.create(Car::new);
        cars.forEach(police::follow);


    }


    public static void print(List<PersonInfo> personInfoList) {
        personInfoList.forEach(personInfo -> System.out.println(personInfo.getName()));
    }


}
