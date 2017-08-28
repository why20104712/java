package com.why.javassist;


import org.apache.ibatis.javassist.*;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Method;

/**
 * 使用javassit生成java类
 *
 * @author wanghaiyang
 * @date 28/08/2017 14:15
 */
@SpringBootTest
public class JavassistTest {

    /**
     * 获取类信息
     */
    @Test
    public void test() throws Exception {
        ClassPool classPool = ClassPool.getDefault();
        CtClass ctClass = classPool.getCtClass("com.why.javaassitst.Person");

        System.out.println(ctClass.getName());
        System.out.println(ctClass.getSimpleName());
        System.out.println(ctClass.getAnnotations());
        System.out.println(ctClass.getClassFile());
        System.out.println(ctClass.toString());

    }

    /**
     * 修改已有方法操作
     */
    @Test
    public void test1() throws Exception {
        ClassPool classPool = ClassPool.getDefault();
        CtClass ctClass = classPool.getCtClass("com.why.javassist.Person");


        CtMethod ctMethod = ctClass.getDeclaredMethod("setId", new CtClass[]{classPool.get("java.lang.Integer")});
        System.out.println(ctMethod);
        ctMethod.insertAfter("System.out.println($1);");

        /**
         * 反射调用方法
         */
        Class clazz = ctClass.toClass();
        Method method = clazz.getDeclaredMethod("setId", Integer.class);
        Object obj = clazz.newInstance();
        Object result = method.invoke(obj, 3);


    }

    /**
     * 创建新方法操作
     */
    @Test
    public void test2() throws Exception {
        ClassPool classPool = ClassPool.getDefault();
        CtClass ctClass = classPool.getCtClass("com.why.javassist.Person");


        CtMethod ctMethod = new CtMethod(CtClass.intType, "add",
                new CtClass[]{CtClass.intType, CtClass.intType}, ctClass);


        ctMethod.setModifiers(Modifier.PUBLIC);

        ctMethod.setBody("{System.out.print(\"返回方法体中的打印信息:\");return $1+$2;}");

        ctClass.addMethod(ctMethod);



        /**
         * 反射调用方法
         */
        Class clazz = ctClass.toClass();
        Method method = clazz.getDeclaredMethod("add", int.class, int.class);
        Object obj = clazz.newInstance();
        Object result = method.invoke(obj, 3, 9);
        System.out.println(result);


    }

    /**
     * 测试产生新的属性
     */
    @Test
    public void test04() throws Exception{
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("com.why.javassist.Person");//获取已有的类

        //CtField f1 = CtField.make("private int salary;", cc);
        //另一种方式
        CtField f1 = new CtField(CtClass.intType, "salary",cc);
        f1.setModifiers(Modifier.PRIVATE);
        cc.addField(f1);

        //cc.getDeclaredField("salary");//获取指定的属性
        //另一种方式
        cc.addMethod(CtNewMethod.getter("getSalary", f1));
        cc.addMethod(CtNewMethod.getter("setSalary", f1));

        //通过反射调用，省略。。。
    }


    /**
     * 测试构造器
     */
    @Test
    public void test05() throws Exception{
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("com.why.javassist.Person");//获取已有的类

        CtConstructor[] cs = cc.getConstructors();
        for (CtConstructor c : cs) {
            System.out.println(c.getLongName());
        }
    }



    public static void main(String[] args) throws Exception {


        ClassPool classPool = ClassPool.getDefault();

        /**
         * 创建类
         */
        CtClass person = classPool.makeClass("Person");

        /**
         * 创建属性
         */
        person.addField(CtField.make("private int id;", person));
        person.addField(CtField.make("private int age;", person));


        /**
         * 创建方法
         */
        person.addMethod(CtMethod.make("private int getId(){return id;}", person));

        /**
         * 创建构造器
         */
        CtConstructor ctConstructor = null;
        ctConstructor = new CtConstructor(new CtClass[]{CtClass.intType, classPool.get("java.lang.Integer")}, person);

        ctConstructor.setBody("{this.id = id; this.age = age;}");

        person.addConstructor(ctConstructor);


        person.writeFile("./Person");


        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.makeClass("com.test.bean.Emp");

        //创建属性
        CtField f1 = CtField.make("private int empno;", cc);
        CtField f2 = CtField.make("private String ename;", cc);

        cc.addField(f1);
        cc.addField(f2);

        //创建方法
        CtMethod m1 = CtMethod.make("public int getEmpno(){return empno;}", cc);
        CtMethod m2 = CtMethod.make("public void setEmpno(){this.empno = empno;}", cc);
        cc.addMethod(m1);
        cc.addMethod(m2);

        //添加构造器
        CtConstructor constructor = new CtConstructor(new CtClass[]{CtClass.intType, pool.get("java.lang.String")}, cc);
        constructor.setBody("{this.empno = empno; this.ename = ename;}");
        cc.addConstructor(constructor);

        cc.writeFile("./Test");//将上面构造好的类写入到指定的工作空间中
    }

}
