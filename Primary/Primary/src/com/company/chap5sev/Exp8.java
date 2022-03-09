package com.company.chap5sev;

import java.io.*;

class Test{
    void createOrDeleteFile(){
        File f = new File("doc"+File.separator+"hello.txt");
        if(f.exists() && f.isFile()) f.delete();
        else{
            try{
                f.createNewFile();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    void copyBytes(String[] args){
        DataInputStream in;
        DataOutputStream out;
        if(args.length != 2){
            System.out.println("Please Enter file names");
            return ;
        }
        File inFile = new File(args[0]);
        File outFile = new File(args[1]);
        if(outFile.exists() && outFile.isFile()){
            System.out.println(args[1]+" already exists");
            return;
        }
        if(!inFile.exists() && outFile.isFile()){
            System.out.println(args[0]+" does not exist");
        }

        try{
            in = new DataInputStream(new BufferedInputStream(
                    new FileInputStream(inFile)));
            out = new DataOutputStream(new BufferedOutputStream(
                    new FileOutputStream(outFile)));
            try{
                int data;
                while(true){
                    data = in.readUnsignedByte();
                    out.writeByte(data);
                }
            }catch (EOFException eof){
                out.close();
                in.close();
                return;
            }
        }catch (FileNotFoundException fe){
            System.out.println("Problem opening files");
        }catch (IOException ioe){
            System.out.println("IO Problems");
        }
    }
}


public class Exp8 {

    public static void main(String[] args) {
        Test t = new Test();
        t.createOrDeleteFile();
        String[] strs = new String[2];
        strs[0] = new String("./doc/hello_backup.txt");
        strs[1] = new String("./doc/hello.txt");
        t.copyBytes(strs);
    }
}
