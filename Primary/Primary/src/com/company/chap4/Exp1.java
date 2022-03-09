package com.company.chap4;

class Point{
    int x, y;
    public Point(int x, int y){this.x = x; this.y = y;}
    public int getX(){return x;}
    public int getY(){return y;}
}

interface Color{
    void setColor(String color);
}

interface Shape{
    double pi = 3.14;
}

interface Shape2D extends Shape {
    Point p = new Point(1, 2);
    double area();
}

class Circle implements Shape2D, Color {
    double radius;
    String color;
    public Circle(double radius){this.radius = radius;}

    @Override
    public double area() {
        System.out.println(pi);
//        System.out.println(super.pi);
        return pi*radius*radius;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }
}

class Rectangle implements Shape2D, Color {
    int width, height;
    String color;
    public Rectangle(int width, int height){this.width = width; this.height = height;}

    @Override
    public double area() {
        return width*height;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }
}

public class Exp1 {
    public static void main(String[] args){
        Rectangle r = new Rectangle(6, 3);
        Circle c = new Circle(2.0);
        System.out.println("Area of rectangle: "+r.area());
        System.out.println("Area of circle: "+c.area());

        Shape2D s1, s2;
        s1 = new Rectangle(5, 6);
        s2 = new Circle(3.0);
        System.out.println("Area of s1: "+s1.area());
        System.out.println("Area of s2: "+s2.area());
        System.out.println(s2.p.getX());

    }
}
