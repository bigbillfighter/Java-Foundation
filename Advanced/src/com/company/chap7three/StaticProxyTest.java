package com.company.chap7three;

abstract class Subject{
    public abstract void request();
}

class RealSubject extends Subject {
    @Override
    public void request() {
        System.out.println("From Real Subject!");
    }
}

class ProxySubject extends Subject {
    private RealSubject realSubject;

    private void preRequest(){
        System.out.println("Pre Request.");
    }

    private void postRequest(){
        System.out.println("Post Request.");
    }

    @Override
    public void request() {
        preRequest();
        if(null==realSubject){
            realSubject = new RealSubject();
        }
        realSubject.request();
        postRequest();
    }
}

public class StaticProxyTest {
    public static void main(String[] args) {
        Subject subject = new ProxySubject();
        subject.request();
    }
}
