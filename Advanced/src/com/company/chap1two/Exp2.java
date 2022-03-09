package com.company.chap1two;

class FactorialThread implements Runnable{
    int num;
    public FactorialThread(int num){
        this.num = num;
    }

    @Override
    public void run() {
        int i = num;
        int result = 1;
        while(i>0){
            result *= i;
            i--;
        }
        System.out.println("The factorial of "+num+" is "+result);
        System.out.println("New thread ends");
    }
}

class TestThread implements Runnable{
    int sleepTime;
    public TestThread(){
        sleepTime = (int)(Math.random()*600);
    }

    @Override
    public void run() {
        try{
            System.out.println(Thread.currentThread().getName()+" going to sleep for "+sleepTime);
            Thread.sleep(sleepTime);
        }catch (InterruptedException e){};
        System.out.println(Thread.currentThread().getName()+" finished");
    }
}

class SellTickets implements Runnable{
    int tickets = 20;

    @Override
    public void run() {
        while(tickets>0){
            System.out.println(Thread.currentThread().getName()+
                " is selling ticket "+tickets--);
        }
    }
}


class Test{
    public static void factorialThreadTester(){
        System.out.println("Main thread starts");
        FactorialThread t = new FactorialThread(10);
        new Thread(t).start();
        System.out.println("Main thread ends");

    }

    public static void threadSleepTester(){
        TestThread t1 = new TestThread();
        TestThread t2 = new TestThread();
        TestThread t3 = new TestThread();
        System.out.println("Threads start");
        new Thread(t1, "Thread1").start();
        new Thread(t2, "Thread2").start();
        new Thread(t3, "Thread3").start();
        System.out.println("Main ends");
    }

    public static void threadShareData(){
        TestThread t = new TestThread();
        System.out.println("Threads start");
        new Thread(t, "Thread1").start();
        new Thread(t, "Thread2").start();
        new Thread(t, "Thread3").start();
        System.out.println("Main ends");
    }

    public static void sellTicketsTester(){
        SellTickets t = new SellTickets();
        new Thread(t).start();
        new Thread(t).start();
        new Thread(t).start();
    }

}

public class Exp2 {
    public static void main(String[] args) {
//        Test.factorialThreadTester();
//        Test.threadSleepTester();
//        Test.threadShareData();
        Test.sellTicketsTester();
    }
}
