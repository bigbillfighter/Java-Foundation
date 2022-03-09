package com.company.chap1one;

class FactorialThread extends Thread{
    private int num;

    public FactorialThread(int num){
        this.num = num;
    }

    @Override
    public void run() {
        super.run();
//        System.out.println(this.getName()); // Thread-0
        int i = num;
        int result = 1;
        System.out.println("new thread started");
        // 实现阶乘
        while(i>0){
            result *= i; i--;
        }
        System.out.println("The factorial of "+num+" is "+result);
        System.out.println("new thread ends");
    }
}

class TestThread extends Thread{
    private int sleepTime;
    public TestThread(String name){
        super(name);
        this.sleepTime = (int)(Math.random()*600);
    }

    @Override
    public void run() {
        super.run();
        try{
            System.out.println(this.getName()+" going to sleep for "+sleepTime);
            Thread.sleep(sleepTime);
        }catch (InterruptedException e){
            System.out.println("Exception happened");
        }
        System.out.println(this.getName()+" finished");
    }
}


class Test{
    public static void factorialThreadTest(){
        System.out.println("Main thread starts");
        FactorialThread t = new FactorialThread(10); // 计算10的阶乘
        t.start();
        System.out.println("Main thread ends");
    }

    public static void factorialThreadTestSleep(){
        System.out.println("Main thread starts");
        FactorialThread t = new FactorialThread(10);
        t.start();
        try{
            Thread.sleep(1);
        }catch (Exception e){
            System.out.println("Exception happened");
        };
        System.out.println("Main thread ends");
    }

    public static void threadSleepTester(){
        TestThread t1 = new TestThread("Thread1");
        TestThread t2 = new TestThread("Thread2");
        TestThread t3 = new TestThread("Thread3");
        System.out.println("Starting threads");
        t1.start(); t2.start(); t3.start();
        System.out.println("Main ends");
    }

}

public class Exp1 {
    public static void main(String[] args) {
//        Test.factorialThreadTest();
//        Test.factorialThreadTestSleep();
        Test.threadSleepTester();
//        Thread.sleep(10); // 线程中端异常。
    }
}
