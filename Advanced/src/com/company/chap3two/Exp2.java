package com.company.chap3two;

import java.util.Vector;
import java.util.concurrent.locks.ReentrantLock;

public class Exp2 {
    private ReentrantLock lock = new ReentrantLock();

    private Vector<Integer> vector = new Vector<>();
    private final int capacity = 10;


    private Thread addThread = new Thread(){
        @Override
        public void run() {
            lock.lock();
            try{
                System.out.println("Start writing");
                for(int i=0; i<capacity; i++){
                    vector.add(new Integer(i+1));
                }
                System.out.println("Done");
            }finally {
                lock.unlock();
            }
        }
    };

    private Thread readThread = new Thread(){
        @Override
        public void run() {
            try{
                lock.lockInterruptibly();
                System.out.println("Start reading");
                for(int j=0; j<vector.size(); j++){
                    System.out.println(vector.get(j));
                    vector.remove(new Integer(j));
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    };


    public static void main(String[] args) throws Exception{
        Exp2 e = new Exp2();
        e.addThread.start();
        e.readThread.start();
    }
}
