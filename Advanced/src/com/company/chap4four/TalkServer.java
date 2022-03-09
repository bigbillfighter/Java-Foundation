package com.company.chap4four;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TalkServer {
    private static String line = null;
    private static Socket socket = null;
    private static BufferedReader sin = null;
    private static PrintWriter os = null;
    private static BufferedReader is = null;
    private static ServerSocket server = null;


    public static void main(String[] args) {
        try{
            try{
                server = new ServerSocket(4888);
            }catch (Exception e) {e.printStackTrace();}

            try{
                socket = server.accept();
            }catch (Exception e) {e.printStackTrace();}

            is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            os = new PrintWriter(socket.getOutputStream());
            sin = new BufferedReader(new InputStreamReader(System.in));

            Thread st = new Thread(){
                @Override
                public void run() {
                    super.run();
                    try{
                        while(true){
                            line = sin.readLine();
                            if(line.equals("bye")){
                                break;
                            }
                            System.out.println("Server: "+line);
                            os.println(line);
                            os.flush();
                        }
                        is.close(); os.close(); sin.close();
                        socket.close(); server.close();
//                        System.out.println("Closed all");
                    }catch (Exception e) {e.printStackTrace();}
                }
            };

            Thread ct = new Thread(){
                @Override
                public void run() {
                    super.run();
                    try{
                        while(true){
                            try{
                                String line = is.readLine();
                                if(line.equals("null")|| line==null);
                                System.out.println("Client: "+line);
                            }catch (NullPointerException e){break;}

                        }
                    }catch (Exception e) {e.printStackTrace();}
                }
            };

            st.start(); ct.start();

        }catch (Exception e) {e.printStackTrace();}
    }
}
