package com.company.chap7four;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Subject {
    public void request();
}

class RealSubject implements Subject {
    public RealSubject(){}

    @Override
    public void request() {
        System.out.println("From real subject");
    }

}

class DynamicSubject implements InvocationHandler{
    private Object sub;
    public DynamicSubject(){}
    public DynamicSubject(Object ob){
        sub = ob;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before calling "+method);
        method.invoke(sub, args);
        System.out.println("After calling "+method);
        return null;
    }
}

public class DynamicProxyTest {
    public static void main(String[] args) throws Throwable {
        Class cls = Class.forName("com.company.chap7four.RealSubject");
        Object rs = cls.newInstance();
        InvocationHandler ds = new DynamicSubject(rs);
        Subject subject = (Subject) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), ds);
        subject.request();
    }
}
