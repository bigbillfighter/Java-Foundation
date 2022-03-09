package com.company.chap5;


class MyException extends RuntimeException{
    public MyException(){
        super("This is a MyException!");
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }
}

public class Exp1 {

    public void tryException(){
        throw new RuntimeException("Error!");
    }

    public static void main(String[] args){
        String[] s = {"Hello", "OK", "Good"};
        try {
            for(int i=0; i<4; i++){
                System.out.println(s[i]);
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e);
            e.printStackTrace();
        }finally {
            System.out.println("Have printed exception");
        }

        Exp1 ep = new Exp1();
        try{
            ep.tryException();
        }catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }finally {
            System.out.println("Done");
        }

        try{
            throw new MyException();
        }catch (MyException e){
            System.out.println("MyException");
            System.out.println(e);
            e.printStackTrace();
        }catch (RuntimeException e){
            System.out.println("RuntimeException");
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
