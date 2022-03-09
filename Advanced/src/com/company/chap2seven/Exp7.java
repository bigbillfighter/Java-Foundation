package com.company.chap2seven;

class Fork{
    int size;
    boolean[] flag;
    public Fork(int size){
        this.size = size;
        flag = new boolean[size];
    }
}

class Philosopher extends Thread{
    private Fork fk;
    int id;
    public Philosopher(Fork f, int id) {
        this.fk = f;
        this.id = id;
    }

    @Override
    public void run() {
        super.run();
        while(true){
            while(fk.flag[id]){}
            fk.flag[id] = true;
            while(fk.flag[(id+1)%fk.size]) {}
            if(fk.flag[id] && !fk.flag[(id+1)%fk.size]){
                fk.flag[(id+1)%fk.size] = true;
                System.out.println("Philosopher "+id+" has two forks");
                fk.flag[id] = false; fk.flag[(id+1)%fk.size] = false;
                try{
                    sleep(1);
                }catch (InterruptedException e){e.printStackTrace();}
            }
        }
    }
}

// 测试死锁
public class Exp7 {
    public static void main(String[] args) {
        int size  = 5;
        Fork f = new Fork(size);
        for(int i =0; i<size; i++){
            new Philosopher(f, i).start();
        }
    }
}
