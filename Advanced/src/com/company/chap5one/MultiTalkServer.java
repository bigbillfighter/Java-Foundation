package com.company.chap5one;

import java.io.IOException;
import java.net.ServerSocket;

public class MultiTalkServer {
    static int clientnum = 0;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        boolean listening = true;
        try{
            serverSocket = new ServerSocket(4888);
            while(listening){
                new ServerThread(serverSocket.accept(), clientnum).start();
                clientnum++;
            }
            serverSocket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
