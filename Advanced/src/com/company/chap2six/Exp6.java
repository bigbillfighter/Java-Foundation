package com.company.chap2six;

class ThreadTest extends Thread {
    @Override
    public void run() {
        super.run();
        while(true){}
    }
}

public class Exp6 {
    public static void main(String[] args) {
        ThreadTest t = new ThreadTest();
        t.setDaemon(true);
        t.start();
        System.out.println("Main ends");
    }
}
