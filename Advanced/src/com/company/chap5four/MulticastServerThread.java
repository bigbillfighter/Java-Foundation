package com.company.chap5four;

import com.company.chap5three.QuoteServerThread;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.util.Date;

public class MulticastServerThread extends QuoteServerThread {
    private long HALF_SECOND = 500;

    public MulticastServerThread() throws IOException{
        super("MulticastServerThread");
    }

    @Override
    public void run() {
        while (moreQuotes){
            try{
                byte[] buf = new byte[256];
                String dSting = null;
                if(in==null) dSting = new Date().toString();
                else dSting = getNextQuote();

                buf = dSting.getBytes();
                InetAddress group = InetAddress.getByName("230.0.0.1");
                DatagramPacket packet = new DatagramPacket(buf, buf.length, group, 4446);
                socket.send(packet);

                try{
                    sleep((long)(Math.random()*HALF_SECOND));
                }catch (InterruptedException e){e.printStackTrace();}
            }catch (IOException e){
                e.printStackTrace();
                moreQuotes = false;
            }
        }
        socket.close();
    }

}
