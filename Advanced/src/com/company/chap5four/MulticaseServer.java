package com.company.chap5four;


import java.io.IOException;

public class MulticaseServer {
    public static void main(String[] args) throws IOException {
        new MulticastServerThread().start();
    }
}
