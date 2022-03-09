package com.company.chap2;

// 练习Java基本的类的申明和调用

import static java.lang.Math.PI;

class Circle{
    int radius;
    public int getRadius(){
        return radius;
    }
    public void setRadius(int radius){
        this.radius = radius;
    }
}

class Rectangle{
    int x, y;
    public int getHeight(){
        return y;
    }
    public int getWidth(){
        return x;
    }
    public void setHeightWidth(int x, int y){
        this.x = x; this.y = y;
    }
}

class CalculateArea{
    static double maxArea(Circle c, Rectangle... varRec){
        double area = 0.0;
        Rectangle[] rec = varRec;
        for(Rectangle r: rec){
            area = area>(r.getHeight()*r.getWidth())?area:(r.getHeight()*(r.getWidth()));
        }
        area = area>(PI*c.getRadius()*c.getRadius())?area:(PI*c.getRadius()*c.getRadius());
        return area;
    }
}

class Clock{
    public int hour, minute, second;
    public Clock(int hour, int minute, int second){
        this.hour = hour; this.minute = minute; this.second = second;
    }
    public Clock(){
        this(0, 0, 0);
    }

    public void setTime(int newH, int newM, int newS){
        hour = newH;
        minute = newM;second = newS;
    }

    public void showTime(){
        System.out.println(hour+":"+minute+":"+second);
    }

    @Override
    protected void finalize() throws Throwable{
        System.out.println("Hello, Java!");
        showTime();
        super.finalize();
    }
}

public class Exp1 {
    public void test(){
        Clock c = new Clock(1, 1, 1);
        Clock d = new Clock();
    }
    public static void main(String[] args){
        Exp1 m = new Exp1();
        m.test();
        System.gc(); // 申请立即回收内存
        System.out.println("ok");
    }
}
