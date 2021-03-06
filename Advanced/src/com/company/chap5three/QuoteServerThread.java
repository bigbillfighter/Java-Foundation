package com.company.chap5three;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

public class QuoteServerThread extends Thread{
    protected DatagramSocket socket = null;
    protected BufferedReader in = null;
    protected boolean moreQuotes = true;

    public QuoteServerThread() throws IOException {
        this("QuoteServerThread");
    }

    public QuoteServerThread(String name) throws IOException{
        super(name);
        socket = new DatagramSocket(4445);
        try{
            in = new BufferedReader(new FileReader("./doc/the-sonnets-part1.txt"));
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try{
            byte[] buf = new byte[256];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);
            String dString = null;
            if(in==null){
                dString = new Date().toString();
            }
            else
                dString = getNextQuote();

            buf = dString.getBytes();

            InetAddress address = packet.getAddress();
            int port = packet.getPort();
            packet = new DatagramPacket(buf, buf.length, address, port);
            socket.send(packet);
        }catch (IOException e){
            e.printStackTrace();
            moreQuotes = false;
        }
        socket.close();
    }

    protected  String getNextQuote(){
        String returnValue = null;
        try{
            if((returnValue=in.readLine())==null){
                in.close();
                moreQuotes = false;
                returnValue = "No more quotes. Goodbye!";
            }
        }catch (IOException e){
            returnValue = "IOException occurred in server!";
        }
        return returnValue;
    }
}
