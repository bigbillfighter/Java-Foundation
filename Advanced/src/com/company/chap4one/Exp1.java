package com.company.chap4one;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

class Test{
    public static void URLReader() throws Exception{
        URL cs = new URL("https://www.sohu.com/a/462896217_267106?code=8aa8c30f5b21d6ad59515ff7728ba991&spm=smpc.home.top-news1.2.1619350679869E0iXkDv&_f=index_cpc_1");

        System.out.println("Protocol: "+cs.getProtocol());
        System.out.println("Host: "+cs.getHost());
        System.out.println("Port: "+cs.getPort());
        System.out.println("File: "+cs.getFile());
        System.out.println("Reference: "+cs.getRef());

        BufferedReader in = new BufferedReader(new InputStreamReader(cs.openStream()));
//        BufferedWriter out = new BufferedWriter(new FileWriter("./doc/sohu.html"));

        String intputLine;
        while((intputLine = in.readLine())!=null){
            System.out.println(intputLine);
//            out.write(intputLine);
//            out.newLine();
        }
        in.close();
//        out.close();
    }
}

public class Exp1 {
    public static void main(String[] args) throws Exception{
        Test.URLReader();
    }
}
