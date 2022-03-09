package com.company.chap5sec;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Exp3 {
    public static void main(String[] args) throws IOException{
        String fileName = "./doc/hello.txt";
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            bw.write("Hello!");
            bw.newLine();
            bw.write("This is a new line!");
            bw.newLine();
            bw.write("The end!");
            bw.newLine();
            bw.close();
        }catch (IOException e){
            System.out.println("Writing error: "+ fileName);
        }
    }
}
