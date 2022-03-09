package com.company.chap3four;


public class Exp4 {
    private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>(){
        public Integer initialValue(){
            return 0;
        }
    };

    public int getNextNum(){
        seqNum.set(seqNum.get()+1);
        return seqNum.get();
    }

    public static void main(String[] args) {
        Exp4 sn = new Exp4();
        TestClient t1 = new TestClient(sn);
        TestClient t2 = new TestClient(sn);
        TestClient t3 = new TestClient(sn);
        t1.start(); t2.start(); t3.start();
    }

    private static class TestClient extends Thread{
        private Exp4 sn;
        public TestClient(Exp4 sn){
            this.sn = sn;
        }

        @Override
        public void run() {
            for(int i=0; i<3; i++){
                System.out.println("thread["+Thread.currentThread().getName()+"] sn["+sn.getNextNum()+"]");
            }
        }
    }
}
