package com.company.chap3one;

import java.util.Vector;

public class Exp1 {
    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {
        while(true){
            for(int i=0; i<10; i++){
                vector.add(i);
            }

            Thread removeThread = new Thread() {
                @Override
                public void run() {
                    synchronized (vector){
                        for(int i=0; i<vector.size(); i++) vector.remove(i);
                    }
                }
            };

            Thread printThread = new Thread(){
                @Override
                public void run() {
                    synchronized (vector){
                        for(int i=0; i<vector.size(); i++) System.out.println(vector.get(i));
                    }
                }
            };

            removeThread.start();
            printThread.start();
            while(Thread.activeCount()>20);
        }
    }
}
