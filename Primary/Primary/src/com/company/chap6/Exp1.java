package com.company.chap6;

import java.util.Arrays;

class Test{
    public static void copyArrays(){
        int[] a = new int[6];
        int[] b = new int[10];
        Arrays.fill(a, 47);
        Arrays.fill(b, 99);
        for(int i: a){
            System.out.print(i+"\t");
        }
        System.out.println();
        for(int i: b){
            System.out.print(i+"\t");
        }
        System.out.println();
        System.arraycopy(a, 0, b, 0, a.length);
        for(int i: b){
            System.out.print(i+"\t");
        }
        System.out.println();
        int[] c = new int[5];
        Arrays.fill(c, 103);
        System.arraycopy(c, 0, a, 0, c.length);
        for(int i: a){
            System.out.print(i+"\t");
        }
        System.out.println();
        Integer[] u = new Integer[5];
        Integer[] v = new Integer[14];
        Arrays.fill(u, new Integer(34));
        Arrays.fill(v, new Integer(50));
        System.arraycopy(u, 0, v, 5, u.length);
        for(Integer i: v){
            System.out.print(i+"\t");
        }
        System.out.println();
    }

    public static void compareArrays(){
        int[] a1 = new int[10];
        int[] a2 = new int[10];
        Arrays.fill(a1, 7);
        Arrays.fill(a2, 7);
        System.out.println(Arrays.equals(a1, a2));
        a2[3] = 11;
        System.out.println(Arrays.equals(a1, a2));

        String[] s1 = new String[5];
        Arrays.fill(s1, "Hi");
        String[] s2 = {"Hi", "Hi", "Hi", "Hi", "Hi"};
        System.out.println(Arrays.equals(s1, s2));
    }
}

public class Exp1 {
    public static void main(String[] args) {
        Test.copyArrays();
        Test.compareArrays();
    }
}
