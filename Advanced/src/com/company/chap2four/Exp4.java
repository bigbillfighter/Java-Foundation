package com.company.chap2four;

import java.util.Vector;

class Semaphore {
    private int S = 1;
    public Semaphore(int S) {
        this.S = S;
    }

    public synchronized void P(){
        S--;
        if (S < 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void V(){
        S++;
        if (S <= 0){
            notify();
        }
    }
}


class Bank {
    private int money = 0;

    public Bank(int money){
        this.money = money;
    }

    public void addMoney(){
        this.money++;
    }

    public int readMoney(){
        return this.money;
    }
}


class AddMoneyThread implements Runnable {
    private final Semaphore sp;
    private final Bank bk;
    private final int addMoneyCount;
    public int id;

    public AddMoneyThread(Bank bk, int addMoneyCount, int id, Semaphore sp) {
        this.bk = bk;
        this.addMoneyCount = addMoneyCount;
        this.id = id;
        this.sp = sp;
    }

    @Override
    public void run() {
        if (bk != null) {
            int index = 1;
            while (index <= this.addMoneyCount) {
                sp.P();
                bk.addMoney();
                index++;
                sp.V();
            }

        }
    }
}

class Test{
    public static void testBank(){
        for (int i = 0; i < 5; i++) {
            Semaphore s = new Semaphore(10);
            Bank bank = new Bank(10000);
            Vector<Thread> v = new Vector<>();
            v.add(new Thread(new AddMoneyThread(bank, 10000, 1, s)));
            v.add(new Thread(new AddMoneyThread(bank, 10000, 2, s)));
            for(Thread t : v){
                t.start();
                try{
                    t.join();
                }catch (InterruptedException e){e.printStackTrace();}
            }

            System.out.println("第" + (i + 1) + "次" + bank.readMoney());
        }
    }
}

public class Exp4 {
    public static void main(String[] args) {
        Test.testBank();
    }
}
