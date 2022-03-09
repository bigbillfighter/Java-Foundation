package com.company.chap5eig;

import java.io.*;
import java.util.zip.*;

class Test{
    void gzipStreamTest() throws IOException{
        FileInputStream in = new FileInputStream("./doc/hello.txt");
        GZIPOutputStream out = new GZIPOutputStream(new FileOutputStream("./doc/hello.gz"));
        System.out.println("Compressing files from doc/hello.txt to doc/test.gz");

        int c;
        while((c = in.read()) != -1) out.write(c); //读写一个字节

        in.close();
        out.close();

        System.out.println("Reading file from doc/hello.gz to minitor");
        BufferedReader in2 = new BufferedReader(new InputStreamReader(
                new GZIPInputStream(new FileInputStream("doc/hello.gz"))));

        String s;
        while((s=in2.readLine())!=null) System.out.println(s);
        in2.close();
        System.out.println("Writing decompression to doc/newHello.txt");
        GZIPInputStream in3 = new GZIPInputStream(new FileInputStream("doc/hello.gz"));
        FileOutputStream out2 = new FileOutputStream("doc/newHello.txt");
        while((c=in3.read())!=-1) out2.write(c);
        in3.close();
        out2.close();
    }

    void zipStreamTest(String[] args) throws IOException{
        ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(
                new FileOutputStream("./doc/test.zip")));

        for(int i=0; i<args.length; i++){
            System.out.println("Writing file e" + args[i]);
            BufferedInputStream in = new BufferedInputStream(
                    new FileInputStream(args[i]));
            out.putNextEntry(new ZipEntry(args[i])); // putNextEntry() 可以记住路径信息，从而可以还原路径关系信息
            int c;
            while((c = in.read()) != -1) out.write(c);
            in.close();
        }
        out.close();
        System.out.println("Reading file");
        ZipInputStream in2 = new ZipInputStream(new BufferedInputStream(
                new FileInputStream("./doc/test.zip")));
        ZipEntry ze;
        while((ze=in2.getNextEntry())!=null){
            System.out.println("Reading file "+ze.getName());
            int x;
            while((x=in2.read())!=-1) System.out.write(x);
            System.out.println();
        }
        in2.close();
    }
}

class Unzip{
    byte doc[] = null;
    String Filename = null;
    String UnZipPath = null;
    public Unzip(String filename, String unZipPath){
        this.Filename = filename;
        this.UnZipPath = unZipPath;
        this.setUnZipPath(this.UnZipPath);
    }

    public Unzip(String filename){
        this.Filename = new String(filename);
        this.UnZipPath = null;
        this.setUnZipPath(this.UnZipPath);
    }

    private void setUnZipPath(String unZipPath){
        if(unZipPath==null || !unZipPath.endsWith("\\"))
            this.UnZipPath = new String(unZipPath+"\\");
        else
            this.UnZipPath = new String(unZipPath);
    }

    public void doUnZip(){
        try{
            ZipInputStream zipin = new ZipInputStream(new FileInputStream(Filename));
            ZipEntry fEntry = null;
            while((fEntry=zipin.getNextEntry())!=null){
                if(fEntry.isDirectory())
                    checkFilePath(UnZipPath+fEntry.getName());
                else{
                    String fname = new String(UnZipPath + fEntry.getName());
                    try{
                        FileOutputStream out = new FileOutputStream(fname);
                        doc = new byte[512];
                        int n;
                        while((n=zipin.read(doc, 0, 512)) != -1)
                            out.write(doc, 0, n);
                        out.close();
                        out=null;
                        doc=null;
                    }catch (Exception ex) {ex.printStackTrace();}
                }
            }
            zipin.close();
        }catch (IOException ioe){
            System.out.println(ioe);
            ioe.printStackTrace();
        }
    }

    private void checkFilePath(String dirName) throws IOException {
        File dir = new File(dirName);
        if(!dir.exists()) dir.mkdirs(); // 可以多级创建目录
    }

}

public class Exp9 {
    public static void main(String[] args) {
        String zipFile = args[0];
        String unZipPath = args[1];
        Unzip myZip = new Unzip(zipFile, unZipPath);
        myZip.doUnZip();
    }
}
