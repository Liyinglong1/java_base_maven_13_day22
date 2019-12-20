package com.lemonban.base.study.readExcel;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectDemo {
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("com.lemonban.base.study.readExcel.Person");
        //1.获取Constructor[]
//        Constructor[] constructors = clazz.getDeclaredConstructors();
//         for (Constructor constructor : constructors) {
//             System.out.println(constructor);
//         }
        //2.获取单个默认构造，并且使用获得的此Constructor 对象，创建类的新实例
        Constructor con = clazz.getConstructor();//返回的是构造方法对象
//        Person person1 = new Person();
//        System.out.println(person1);
        //调用Constructor的newInstance()方法，实例化对象
        Object obj = con.newInstance();
        System.out.println(obj);
//        Person person2 = (Person)obj;
//        person2.show();     
   
        Method method2 = clazz.getMethod("method", String.class);
        method2.invoke(obj, "hello");
    }
}
