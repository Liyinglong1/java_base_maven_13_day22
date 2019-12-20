package com.lemonban.base.study.readExcel;

public class Person {
    /**
     * 3种范围的成员变量:private, 默认,public
     * */
    public String name;
    int age;
    public String address;
    /**构造函数：无参, 有参(1,2,3个参数)*/
    public Person() {
    }
    private Person(String name) {
        this.name = name;
    }
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
    /**
     * 成员函数：
     * ①public, private 
     * ②有参,无参
     * ③无返回值(void),有返回值
     * */
    public void show() {
        System.out.println("show");
    }
    public void method(String s) {
        System.out.println(name + s);
    }
    public String getString(String s, int i) {
        return s + "---" + i;
    }
    private void function() {
        System.out.println("function");
    }
    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", address=" + address+ "]";               
    }
}
