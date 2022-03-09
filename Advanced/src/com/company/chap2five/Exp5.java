package com.company.chap2five;


class Tickets{
    int number = 0; // 票的编号
    int size; // 总票数
    boolean available = false; // 是否可售
    public Tickets(int size) {this.size = size;}

    public synchronized void put(){ // 实现存票功能
        if(available){
            try{
                wait();
            }catch (Exception e){}
        }
        System.out.println("Producer puts tickets "+(++number));
        available = true;
        notify();
    }
    public synchronized void sell(){ // 实现取票的功能
        if(!available){
            try{
                wait();
            }catch (Exception e){}
        }
        System.out.println("Consumer buys ticket "+(number));
        available = false;
        notify();
//        if(number==size) number++;
    }
}

class Producer extends Thread{
    Tickets t = null;
    public Producer(Tickets t) {this.t=t;}

    @Override
    public void run() {
        super.run();
        while(t.number<t.size) t.put();
    }
}

class Consumer extends Thread{
    Tickets t = null;
    public Consumer(Tickets t) {this.t = t;}

    @Override
    public void run() {
        super.run();
        while(t.number < t.size)
            t.sell();
    }
}

class Test{
    public static void testWaitNotify(){
        Tickets t = new Tickets(10);
        new Consumer(t).start();
        new Producer(t).start();
    }
}

public class Exp5 {
    public static void main(String[] args) {
        Test.testWaitNotify();
    }
}
