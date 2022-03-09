package com.company.chap6fir;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

class Test{
    public static void iteratorTester(){
        String[] num = {"one", "two", "three", "four", "five",
                "six", "seven", "eight", "nine", "ten"};
        // 使用 asList() 将num包装成 ArrayList 类型
        Vector<String> avec = new Vector<>(java.util.Arrays.asList(num));
        System.out.println("Before Vector: " + avec);
        Iterator<String> it = avec.iterator();
        while(it.hasNext()){
            String s = (String)it.next();
            System.out.println(s);
            if(s.length()>4) it.remove();
        }
        System.out.println("After Vector: " + avec);
    }

    public static void forTester(){
        Enumeration<String > days;
        Vector<String > dayNames = new Vector();
        dayNames.add("Sunday"); dayNames.add("Monday");
        dayNames.add("Tuesday"); dayNames.add("Wednesday");
        dayNames.add("Thursday"); dayNames.add("Friday");
        dayNames.add("Saturday");

        days = dayNames.elements();
        for(String day: dayNames){
            System.out.println(day);
        }
    }
}

public class Exp2 {
    public static void main(String[] args) {
        Test.iteratorTester();
        Test.forTester();
    }
}
