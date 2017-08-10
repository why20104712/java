package com.why.service;

import java.util.function.Supplier;

/**
 * 个人信息工厂类
 * Created by why on 13/07/2017.
 */
public class PersonInfoFactory {

    private Supplier<PersonInfo> personInfoSupplier;

    public PersonInfoFactory(Supplier<PersonInfo> personInfoSupplier) {
        this.personInfoSupplier = personInfoSupplier;
    }


    public PersonInfo getPersonInfo(){
        return personInfoSupplier.get();
    }
}
