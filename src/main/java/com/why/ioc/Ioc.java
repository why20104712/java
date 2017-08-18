package com.why.ioc;


import com.why.bean.Address;
import com.why.bean.MyService;
import com.why.bean.Person;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * IOC容器测试
 *
 * @author wanghaiyang
 * @date 14/08/2017 16:44
 */
public class Ioc {


    public static void main(String[] args) {

        /**
         * 使用代码手动往IOC容器注入bean
         */

        DefaultListableBeanFactory beanDefinitionRegistry = new DefaultListableBeanFactory();
        /**
         *将bean定义注册到容器中
         */
        AbstractBeanDefinition personBeanDefinition = new RootBeanDefinition(Person.class);
        AbstractBeanDefinition addressBeanDefinition = new RootBeanDefinition(Address.class);
        beanDefinitionRegistry.registerBeanDefinition("person", personBeanDefinition);
        beanDefinitionRegistry.registerBeanDefinition("address", addressBeanDefinition);

        BeanFactory beanFactory = (BeanFactory) beanDefinitionRegistry;
        Person person = (Person) beanFactory.getBean("person");
        Address address = (Address) beanFactory.getBean("address");


        /**
         * 构造方法注入
         */
        ConstructorArgumentValues constructorArgumentValues = new ConstructorArgumentValues();
        constructorArgumentValues.addIndexedArgumentValue(0, address);

        personBeanDefinition.setConstructorArgumentValues(constructorArgumentValues);

        /**
         * 属性注入
         */
        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
        mutablePropertyValues.addPropertyValue(new PropertyValue("address", address));
        personBeanDefinition.setPropertyValues(mutablePropertyValues);

        System.out.println(person.getName());
    }


}
