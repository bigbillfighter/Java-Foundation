package com.company.chap3three;

import java.util.concurrent.atomic.AtomicInteger;

class Counter{
    private volatile int count=0;
    public synchronized void increment(){
        count++;
    }
    public int getCount(){
        return count;
    }
}

class AtomicCounter{
    private AtomicInteger count = new AtomicInteger();
    public void increment(){
        count.incrementAndGet();
    }
    public int getCount(){
        return count.get();
    }
}

public class Exp3 {
    public static void main(String[] args) {

    }
}
