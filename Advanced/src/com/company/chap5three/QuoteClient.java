package com.company.chap5three;


import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class QuoteClient {
    public static void main(String[] args) {
        if(args.length!=1){
            System.out.println("Please input hostname");
            return ;
        }
        try{
            DatagramSocket socket = new DatagramSocket();
            byte[] buf = new byte[256];
            InetAddress address = InetAddress.getByName(args[0]);
            DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 4445);
            socket.send(packet);

            packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);

            String received = new String(packet.getData());
            System.out.println("Quote of the Moment: "+received);
            System.out.println(new String(buf));
            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
