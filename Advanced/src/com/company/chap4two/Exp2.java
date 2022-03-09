package com.company.chap4two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

class Test{
    public static void testURLConnect(){
        try {
            URL cs = new URL("https://www.sohu.com");
            URLConnection tc = cs.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(tc.getInputStream()));
            String inputLine;
            while((inputLine = in.readLine())!=null){
                System.out.println(inputLine);
            }
            in.close();
        }catch (MalformedURLException e){
            System.out.println("A MalformedURLException happened");
        }catch (IOException e){
            System.out.println("An IOException happened");
        }
    }
}


public class Exp2 {
    public static void main(String[] args) {
        Test.testURLConnect();
    }
}
