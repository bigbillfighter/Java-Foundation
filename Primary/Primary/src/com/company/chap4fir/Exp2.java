package com.company.chap4fir;

class People{
    String name;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}

class Employee extends People {
    public void computePay(){
        System.out.println("Low Payment");
    }
    public static void payType(){
        System.out.println("Employee pay type");
    }
}

class Manager extends Employee {

    @Override
    public void computePay(){
        System.out.println("High Payment");
    }

    public static void payType(){
        System.out.println("Manager pay type");
    }

    // 子类没有这个方法的时候，即使使用类型转换，也用不了这个方法
    public void teem(){
        System.out.println("I have a teem");
    }

    // 静态方法子类用不了
    public static void teemType(){
        System.out.println("Manager teem type");
    }
}

public class Exp2 {
    public static void main(String[] args){
        Manager m = new Manager();
        Employee e = new Employee();
        Employee s = m;
        m.computePay();
        e.computePay();
        s.computePay();

        m.payType();
        e.payType();
        s.payType(); // 静态方法会直接从自己的类里面调用。

    }
}
