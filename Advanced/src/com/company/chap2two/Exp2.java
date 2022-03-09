package com.company.chap2two;

class Tickets{
    int number = 0; // 票的编号
    int size; // 总票数
    boolean available = false; // 是否可售
    public Tickets(int size) {this.size = size;}
}

class Producer extends Thread{
    Tickets t = null;
    public Producer(Tickets t) {this.t = t;}

    @Override
    public void run() {
        super.run();
        while(t.number<t.size){
            synchronized (t){
                System.out.println("Producer puts ticket "+(++t.number));
                t.available = true;
            }
        }
    }
}

class Consumer extends Thread{
    Tickets t = null;
    int i=0;
    public Consumer(Tickets t) {this.t = t;}

    @Override
    public void run() {
        super.run();
        while(i<t.size){
            synchronized (t){
                if(t.available && i<t.number)
                    System.out.println("Consumer buys ticket "+(++i));
                if(i==t.number){
//                    try {
//                        sleep(1);
//                    }catch (InterruptedException e) {}
                    t.available = false;
                }
            }
        }
    }
}


class Test{
    public static void testSynchronized(){
        Tickets t = new Tickets(10); // 最大存票数为10
        new Consumer(t).start();
        new Producer(t).start();
    }

}

public class Exp2 {
    public static void main(String[] args) {
        Test.testSynchronized();
    }
}
