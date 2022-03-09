package com.company.chap5fif;

import java.io.*;

public class Exp6 {


    public void dataStreamWriteInt() throws IOException {
        String fileName = "./doc/data1.dat";
        int value0=255, value1=0, value2=-1;
        DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName));
        out.writeInt(value0);
        out.writeInt(value1);
        out.writeInt(value2);
        out.close();
        // 结果为 0000 00ff 0000 0000 ffff ffff
    }

    public void bufferedStreamWriteTypes() throws IOException{
        String fileName = "./doc/mixedTypes.dat";
        DataOutputStream dataOut = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));
        dataOut.writeInt(0);
        System.out.println(dataOut.size()+" bytes written");
        dataOut.writeDouble(31.2);
        System.out.println(dataOut.size()+" bytes written");
        dataOut.writeBytes("JAR");
        System.out.println(dataOut.size()+" bytes written");
        dataOut.close();
    }

    public void writeOneByte() throws IOException{
        DataOutputStream out = new DataOutputStream(new FileOutputStream("./doc/tryonce.dat"));
        out.writeByte(-1); out.close();
        DataInputStream in = new DataInputStream(new FileInputStream("./doc/tryonce.dat"));
        int a = in.readByte(); // 虽然只存储了低 8 位，但是这里会为高位补 0。
        System.out.println(Integer.toHexString(a)); // 转为 16 进制表示
        System.out.println(a); // 输出 a
        in.skip(-1); // 回退 1 字节以便重新读入。
        a = in.readUnsignedByte();
        System.out.println(Integer.toHexString(a));
        System.out.println(a);
        in.close();
    }

    public void dataStreamReadInt() {
        String fileName = "./doc/data1.dat";
        int sum=0;
        try{
            DataInputStream in = new DataInputStream(
                    new BufferedInputStream(new FileInputStream(fileName)));
            try{
                while(true) sum += in.readInt();
            }catch (EOFException eof){
                System.out.println("Sum: "+sum);
                in.close();
            }
        }catch (IOException e){
            System.out.println("Problem reading "+fileName);
        }
    }

    public void streamReadDocument(){
        String fileName = "./doc/hello.txt";
        try{
            FileInputStream s = new FileInputStream(fileName);
            int c;
            while((c=s.read())!=-1) System.out.write(c); // read 读取一个字节
            // write 会将低八位写入标准输出设备——显示器
            s.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public void streamCopy(String[] args){
        DataInputStream in;
        DataOutputStream out;
        if(args.length !=2){
            System.out.println("Please enter file names");
            return;
        }
        try{
            in = new DataInputStream(
                    new BufferedInputStream(new FileInputStream(args[0])));
            out = new DataOutputStream(
                    new BufferedOutputStream(new FileOutputStream(args[1])));
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
            System.out.println("IO problems");
        }
    }

    public static void main(String[] args) throws IOException{
        new Exp6().dataStreamWriteInt();
        new Exp6().bufferedStreamWriteTypes();
        new Exp6().writeOneByte();
        new Exp6().dataStreamReadInt();
        new Exp6().streamReadDocument();
        new Exp6().streamCopy(args);
    }
}
