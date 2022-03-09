package com.company.chap1;

// Java的基础特性

public class Exp1 {

    // 引用之间的赋值类似于指针的赋值
    public static void exp1TestArray(){
        int[] a1 = {1, 2, 3, 4};
        int[] a2;
        a2 = a1;
        for(int i=0; i<a2.length; i++) a2[i]++;
        for(int i=0; i<a1.length; i++){
            System.out.println("a1["+i+"]="+a1[i]);
        }
    }

    public static void exp2StringArray(){
        String[] a = {"String One", "String two", "String three"};
        for (String s : a) {
            System.out.println(s.toLowerCase());
        }
    }

    public static void exp3ArrayCopy(){
        char[] a = {'d', 'i', 'f', 'f', 'e', 'r', 'e', 'n', 't'};
        char[] b = new char[4];

        //srcArray, srcStartPos, desArray, desStartPos, copyLength
        System.arraycopy(a, 2, b, 0, 3);
        System.out.println(new String(b)); //可以用字符数组作为参数创建字符串
    }

    public static void exp4Array2D(){
        int[][] a = {{1, 2, 3}, {4, 5}, {6, 7, 8, 9}};
        System.out.println(a.length);//二维数组是一维数组的数组，仅仅是一维数组引用的数组
        System.out.println(a[0].length);//二维数组每一行的元素个数可以不同
        System.out.println(a[1].length);
        System.out.println(a[2].length);

    }


    public static void main(String[] args) {
        exp4Array2D();
    }
}
