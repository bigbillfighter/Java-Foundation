package com.company.chap4four;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

public class TalkClient {
    private static String readLine = null;
    private static Socket socket = null;
    private static BufferedReader sin = null;
    private static PrintWriter os = null;
    private static BufferedReader is = null;

    public static void main(String[] args) {
        try{
            socket = new Socket("127.0.0.1", 4888);
            sin = new BufferedReader(new InputStreamReader(System.in));
            os = new PrintWriter(socket.getOutputStream());
            is = new BufferedReader(new InputStreamReader(socket.getInputStream()));


            Thread ct = new Thread(){
                @Override
                public void run() {
                    super.run();
                    try{
                        while(true){
                            readLine = sin.readLine();
                            if(readLine.equals("bye")){
                                break;
                            }
                            System.out.println("Client: "+readLine);
                            os.println(readLine);
                            os.flush();
                        }
                        os.close(); is.close();sin.close();
                        socket.close();
//                        System.out.println("Closed all");
                    }catch (Exception e) {e.printStackTrace();}
                }
            };

            Thread st = new Thread(){
                @Override
                public void run() {
                    try{
                        while(true){
                            String line;
                            try{
                                line = is.readLine();
                            }catch (SocketException e) {break;}
                            System.out.println("Server: " + line);

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
