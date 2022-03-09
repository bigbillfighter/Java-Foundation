package com.company.chap2fir;

// 练习枚举类
enum Planet{

    EARTH(5.976e24, 6.37814e6),
    JUPITER(1.9e27, 7.1492e7);

    private final double mass, radius;
    public static final double G = 6.673E-11;

    Planet(double mass, double radius){
        this.mass = mass; this.radius = radius;
    }

    public double getMass(){
        return mass;
    }
    public double getRadius(){
        return radius;
    }

}

public class Exp2 {
    public static void main(String[] args){
        System.out.println(Planet.EARTH.getMass());
        System.out.println(Planet.values()[1]);
        System.out.println(Planet.EARTH.toString().toLowerCase());
        System.out.println(Planet.valueOf("EARTH").getMass());
        System.out.println(Planet.valueOf("jupiter".toUpperCase()).ordinal());
    }
}
