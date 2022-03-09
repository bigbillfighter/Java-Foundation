package com.company.chap2nine;

import java.util.ArrayList;
import java.util.List;

class Goods{
    int id;
    public Goods(int id) {this.id = id;}
}

class SyncSemaphore {
    private int idle = 0; // 空
    private int used = 0; // 满
    private int mutex = 1;

    public SyncSemaphore(int idle, int used){
        this.idle = idle;
        this.used = used;
    }

    public synchronized void PEmpty(){
        idle--;
        if (idle < 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void VEmpty(){
        idle++;
        if (idle <= 0){
            notify();
        }
    }

    public synchronized void PFull(){
        used--;
        if (used < 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void VFull(){
        used++;
        if (used <= 0){
            notify();
        }
    }
    public synchronized void PMutex(){
        mutex--;
        if (mutex < 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void VMutex(){
        mutex++;
        if (mutex <= 0){
            notify();
        }
    }
}

class Repository {
    private Goods[] goodsArray;
    private int usedSize = 0;

    public Repository(int goodSize){
        goodsArray = new Goods[goodSize];
    }

    public void saveGood(int goodId) {
        if (usedSize < goodsArray.length) {
            goodsArray[usedSize++] = new Goods(goodId);
        }
    }

    public Goods takeGood(){
        if (usedSize == 0){
            return null;
        }
        return goodsArray[--usedSize];
    }
}


class SaveGoodThread implements Runnable{
    private Repository repository;
    private int saveNumber = 0;
    SyncSemaphore s;

    public SaveGoodThread(Repository repository, int saveNumber, SyncSemaphore s){
        this.repository = repository;
        this.saveNumber = saveNumber;
        this.s = s;
    }

    /* saveGoodThread */
    @Override
    public void run(){
        if (repository != null){
            int i = 0;
            while (i < this.saveNumber){
                s.PEmpty();
                s.PMutex();
                repository.saveGood(i + 1);
                i++;
                s.VMutex();
                s.VFull();
            }
        }
    }
}

class TakeGoodThread implements Runnable {
    private int number = 0;
    private List<Goods> goodsList = null;
    private Repository repository;
    private int takeNumber;
    SyncSemaphore s;

    public TakeGoodThread(Repository repository, int takeNumber, List<Goods> goodsList, SyncSemaphore s) {
        this.repository = repository;
        this.goodsList = goodsList;
        this.s = s;
        this.takeNumber = takeNumber;
    }

    @Override
    public void run() {
        while (number<takeNumber) {
            s.PFull();
            s.PMutex();
            Goods temp = repository.takeGood();
            if (temp != null){
                number++;
                goodsList.add(temp);
            }
            s.VEmpty();
            s.VMutex();
        }
    }

}


public class Exp9 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++){
            Repository repository = new Repository(10);
            List<Goods> goodsList = new ArrayList<>();
            SyncSemaphore s = new SyncSemaphore(8, 2);

            Thread saveGood = new Thread(new SaveGoodThread(repository, 10000, s));
            Thread takeGood = new Thread(new TakeGoodThread(repository, 10000, goodsList, s));
            saveGood.start();
            takeGood.start();

            try {
                saveGood.join();
                takeGood.join();
                System.out.println("第" + (i + 1) + "次" + goodsList.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
