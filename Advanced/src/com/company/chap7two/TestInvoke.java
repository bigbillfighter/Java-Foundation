package com.company.chap7two;

import java.lang.reflect.Method;

public class TestInvoke {
    public void add(Integer p1, Integer p2){
        System.out.println(p1.intValue()+p2.intValue());
    }

    public void stringAdd(String abc){
        System.out.println("out"+abc);
    }

    public static void main(String[] args) {
        try{
            Method mth = TestInvoke.class.getMethod("add", new Class[]{Integer.class, Integer.class});
            mth.invoke(TestInvoke.class.newInstance(), new Integer(1), new Integer(2));
            Method mth_two = TestInvoke.class.getMethod("stringAdd", new Class[]{String.class});
            mth_two.invoke(TestInvoke.class.newInstance(),"--test");

        }catch (Exception e){}
    }
}
