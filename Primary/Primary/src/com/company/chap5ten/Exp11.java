package com.company.chap5ten;

import java.io.RandomAccessFile;

class Employee {
    // \\u 表示后面是一个 unicode 编码
    char[] name = {'\u0000', '\u0000', '\u0000', '\u0000',
            '\u0000', '\u0000', '\u0000', '\u0000'};
    int age;
    public Employee(String name, int age) throws Exception{
        if(name.toCharArray().length > 8)
            System.arraycopy(name.toCharArray(), 0, this.name, 0, 8);
        else
            System.arraycopy(name.toCharArray(), 0, this.name, 0, name.toCharArray().length);

        this.age = age;
    }

}

public class Exp11 {
    String FileName;
    public Exp11(String fileName){
        this.FileName = fileName;
    }

    public void writeEmployee(Employee e, int n) throws Exception{
        RandomAccessFile ra = new RandomAccessFile(FileName, "rw");
        ra.seek(n*20);
        for(int i=0; i<8; i++) ra.writeChar(e.name[i]);
        ra.writeInt(e.age);
        ra.close();
    }

    public void readEmployee(int n) throws Exception{
        char buf[] = new char[8];
        RandomAccessFile ra = new RandomAccessFile(FileName, "r");
        ra.seek(n*20);
        for(int i=0; i<8; i++) buf[i] = ra.readChar();
        System.out.print("name: ");
        System.out.println(buf);
        System.out.println("age: "+ra.readInt());
        ra.close();
    }

    public static void main(String[] args) throws Exception{
        Exp11 ep = new Exp11("./doc/random.txt");
        Employee e1 = new Employee("LucasP", 23);
        Employee e2 = new Employee("李华", 19);
        Employee e3 = new Employee("张力", 33);

        ep.writeEmployee(e1, 0);
        ep.writeEmployee(e3, 2);
        System.out.println("第一个雇员信息：");
        ep.readEmployee(0);
        System.out.println("第二个雇员信息：");
        ep.readEmployee(2);
        ep.writeEmployee(e2, 1);
        System.out.println("第三个雇员信息: ");
        ep.readEmployee(1);
    }
}
