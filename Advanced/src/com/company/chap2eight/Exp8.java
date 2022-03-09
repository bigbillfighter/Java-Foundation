package com.company.chap2eight;

class TestThread extends Thread{
    private int tick = 1;
    private int num;
    public TestThread(int i){this.num = i;}

    @Override
    public void run() {
        super.run();
        while(tick<40000){
            tick++;
            if((tick%10000)==0){
                System.out.println("Thread #"+num+", tick = "+tick);
                yield(); // 放弃执行权
            }
        }
    }
}

public class Exp8 {
    public static void main(String[] args) {
        TestThread[] runners = new TestThread[2];
        for(int i=0; i<2; i++){
            runners[i] = new TestThread(i);
        }
        runners[0].setPriority(2);
        runners[1].setPriority(3);
        for(int i=0; i<2; i++) runners[i].start();
    }
}
