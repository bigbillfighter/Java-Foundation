package com.company.chap5fou;

import java.io.*;

class CopyMaker{
    String srcName, dstName;
    BufferedReader src;
    BufferedWriter dst;
    String line;

    private boolean openFiles(){
        try{
            src = new BufferedReader(new FileReader(srcName));
        }catch (IOException e) {
            System.out.println("Problem opening " + srcName);
            e.printStackTrace();
            return false;
        }

        try{
            dst = new BufferedWriter(new FileWriter(dstName));
        }catch (IOException e){
            System.out.println("Problem opening " + dstName);
            e.printStackTrace();
            return false;
        }

        return true;
    }

    private boolean copyFiles() {
        try {
            while ((line = src.readLine()) != null) {
                dst.write(line);
                dst.newLine();
            }
        } catch (IOException e) {
            System.out.println("Problem reading or writing");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private boolean closeFiles(){
        boolean rst = true;
        try{
            src.close();
        }catch (IOException e){
            System.out.println("Problem closing " + srcName);
            e.printStackTrace();
            rst = false;
        }

        try{
            dst.close();
        }catch (IOException e){
            System.out.println("Problem closing" + dstName);
            e.printStackTrace();
            rst = false;
        }
        return rst;
    }

    public boolean copy(String source, String destination){
        srcName = source; dstName = destination;
        return openFiles() && copyFiles() && closeFiles();
    }
}

public class Exp5 {
    public static void main(String[] args) {
        if(args.length == 2) new CopyMaker().copy(args[0], args[1]);
        else System.out.println("Please Enter right File names");
    }
}
