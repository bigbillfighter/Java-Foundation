package com.company.chap2one;

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
            System.out.println("Producer puts ticket "+(++t.number));
            t.available = true;
        }
    }
}

class Consumer extends Thread{
    Tickets t = null;
    int i=0; // 当前要售出的编号
    public Consumer(Tickets t){this.t = t;}

    @Override
    public void run() {
        super.run();
        while(i<t.size){
            if(t.available && i<t.number)
                System.out.println("Consumer buys ticket "+(++i));
            if(i==t.number){ // 票卖完了
                try{
                    sleep(1);
                }catch (InterruptedException e){}
                t.available = false;
            }
        }
    }
}

class Test{
    public static void testSellTickets(){
        Tickets t = new Tickets(10); // 最大存票数为10
        new Consumer(t).start();
        new Producer(t).start();
    }
    public static void testSellTicketsChangeOrder(){
        Tickets t = new Tickets(10); // 最大存票数为10
        new Producer(t).start();
        new Consumer(t).start();
    }
}

public class Exp1 {
    public static void main(String[] args) {
        Test.testSellTickets();
//        Test.testSellTicketsChangeOrder();
    }
}
