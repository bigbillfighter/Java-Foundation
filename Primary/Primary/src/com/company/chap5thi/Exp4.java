package com.company.chap5thi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Exp4 {
    public void bufferedRead(){
        String fileName = "./doc/hello.txt", line;
        try{
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            while((line=in.readLine()) != null){
                System.out.println(line);
            }
            in.close();
        }catch (IOException e){
            System.out.println("Problem reading in "+fileName);
            e.printStackTrace();
        }
    }

    public void readerRead(){
        String fileName = "./doc/hello.txt";
        int c;
        try{
            FileReader in = new FileReader(fileName);
            while((c=in.read()) != -1){
                System.out.print((char)c);
            }
            in.close();
        }catch (IOException e){
            System.out.println("Problem reading in "+fileName);
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
//        new Exp4().bufferedRead();
        new Exp4().readerRead();
    }
}
