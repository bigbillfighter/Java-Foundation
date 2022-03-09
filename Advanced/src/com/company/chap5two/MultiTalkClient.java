package com.company.chap5two;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MultiTalkClient {

    Socket socket = null;
    BufferedReader sin = null;
    PrintWriter os = null;
    BufferedReader is = null;
    String readline;
    String line;

    public static void main(String[] args) {
        MultiTalkClient m = new MultiTalkClient();
        try{
            m.socket = new Socket("127.0.0.1", 4888);
            m.sin = new BufferedReader(new InputStreamReader(System.in));
            m.os = new PrintWriter(m.socket.getOutputStream());
            m.is = new BufferedReader(new InputStreamReader(m.socket.getInputStream()));

            Thread ct = new Thread(){
                @Override
                public void run() {
                    try{
                        while(true){
                            m.readline = m.sin.readLine();
                            if(m.readline.equals("bye")){
                                break;
                            }
                            System.out.println("Client: "+m.readline);
                            m.os.println(m.readline);
                            m.os.flush();
                        }
                        m.os.close(); m.is.close(); m.sin.close();
                        m.socket.close();
                    }catch (Exception e) {e.printStackTrace();}
                }
            };

            Thread st = new Thread(){
                @Override
                public void run() {
                    try{
                        while(true){
                            try{
                                m.line = m.is.readLine();
                            }catch (java.net.SocketException e) {break;}
                            System.out.println("Server: " + m.line);

                        }
                    }catch (Exception e) {e.printStackTrace();}
                }
            };

            ct.start(); st.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
