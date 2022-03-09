package com.company.chap7one;

class AirPlane{
    @Override
    public String toString() {
        return "In airPlane!";
    }
}

public class CreateInstance {
    public static void main(String[] args) throws Exception{
        Class c1 = Class.forName("com.company.chap7one.AirPlane");
        Object ap = null;
        System.out.println(c1);
        ap = c1.newInstance();
        System.out.println(ap.toString());
    }
}
