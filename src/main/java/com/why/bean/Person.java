package com.why.bean;

public class Person {


    private String name;

    private Address address;

    public String getName() {
        return "name + why";
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(Address address) {
        this.address = address;
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }


}
