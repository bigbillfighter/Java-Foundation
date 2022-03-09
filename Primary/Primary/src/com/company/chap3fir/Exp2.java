package com.company.chap3fir;

abstract class Shape{
    abstract double area();
}

class Circle extends Shape {
    int radius;
    final double PI = Math.PI;
    Circle(int radius){this.radius= radius;}
    double area(){
        return PI*radius*radius;
    }
}

public class Exp2 {
    public static void main(String[] args){
        Circle c1 = new Circle(10);
        System.out.println(c1.area());
    }
}
