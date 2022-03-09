package com.company.chap5one;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread{
    Socket socket = null;
    int clientnum;
    public ServerThread(Socket socket, int num){
        this.socket = socket;
        clientnum = num+1;
    }

    @Override
    public void run() {
        try{
            String line;
            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter os = new PrintWriter(socket.getOutputStream());
            BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Client"+clientnum+": "+is.readLine());
            line = sin.readLine();
            while(!line.equals("bye")){
                os.println(line);
                os.flush();
                System.out.println("Server:"+line);
                System.out.println("Client"+clientnum+": "+is.readLine());
                line = sin.readLine();
            }
            os.close(); is.close(); sin.close();
            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
