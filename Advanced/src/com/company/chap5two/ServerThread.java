package com.company.chap5two;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread{
    Socket socket = null;
    int clientnum;

    String readline = null;
    String line = null;
    BufferedReader sin = null;
    PrintWriter os = null;
    BufferedReader is = null;

    public ServerThread(Socket socket, int num){
        this.socket = socket;
        clientnum = num+1;
    }

    @Override
    public void run() {
        try{
            is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            os = new PrintWriter(socket.getOutputStream());
            sin = new BufferedReader(new InputStreamReader(System.in));

            Thread st = new Thread(){
                @Override
                public void run() {
                    try{
                        while(true){
                            line = sin.readLine();
                            if(line.startsWith(""+clientnum)){
                                line = line.split(" ")[1];
                                System.out.println(line);
                                if(line.equals("bye")){
                                    break;
                                }
                                System.out.println("Server: "+line);
                                os.println(line);
                                os.flush();

                            }
                        }
                        is.close(); os.close(); sin.close();
                        socket.close();
                    }catch (Exception e) {e.printStackTrace();}
                }
            };

            Thread ct = new Thread(){
                @Override
                public void run() {
                    try{
                        while(true){
                            try{
                                readline = is.readLine();
                                if(readline.equals("null")|| readline==null);
                                System.out.println("Client"+clientnum+": "+readline);
                            }catch (NullPointerException e){break;}

                        }
                    }catch (Exception e) {e.printStackTrace();}
                }
            };

            st.start(); ct.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
