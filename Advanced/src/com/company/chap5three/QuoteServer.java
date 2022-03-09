package com.company.chap5three;

import java.io.IOException;

public class QuoteServer {
    public static void main(String[] args) throws IOException{
        new QuoteServerThread().start();
    }
}


