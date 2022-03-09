package com.company.chap3;

class A{
    int x = 2;
    public void setX(int x){
        this.x = x;
    }
    public void printA(){
        System.out.println(x);
    }
}

class B extends A {
    int x = 100;
    public void printB(){
        super.x += 10;
        System.out.println("super.x: "+super.x+", x: "+x);
    }
}

public class Exp1 {
    public static void main(String[] args){
        A a = new A();
        a.printA();
        a.setX(4);
        a.printA();

        B b = new B();
        b.printA();
        b.printB();
        b.setX(4);
        b.printB();
        a.printA();
    }
}
