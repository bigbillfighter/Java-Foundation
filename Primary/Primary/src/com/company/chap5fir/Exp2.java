package com.company.chap5fir;

import java.io.*;

public class Exp2 {
    public static void main(String[] args) throws IOException {
        String readPath = "./doc/src.txt";
        String writePath = "./doc/rst.out";
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(readPath));
        PrintStream out = new PrintStream(new FileOutputStream(writePath));
        System.setIn(in); System.setOut(out); System.setErr(out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s = br.readLine())!=null) System.out.println(s);
        in.close();
        out.close();
    }
}
