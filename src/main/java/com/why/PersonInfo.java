package com.why;

/**
 * 个人信息
 * Created by why on 13/07/2017.
 */
public class PersonInfo implements Comparable<PersonInfo> {

    private String name;

    private Integer age;

    public Integer getAge() {
        return age;
    }

    public PersonInfo() {
    }

    public PersonInfo(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(PersonInfo o) {
        return o.getName().compareTo(this.getName());
    }


    public static int compare(PersonInfo p1, PersonInfo p2){
        return p2.getName().compareTo(p1.getName());
    }


    public int compareTo(PersonInfo p1, PersonInfo p2) {
        return p2.getName().compareTo(p1.getName());
    }

}
