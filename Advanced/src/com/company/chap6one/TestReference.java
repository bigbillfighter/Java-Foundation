package com.company.chap6one;

import java.lang.ref.PhantomReference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class TestReference {

    static void testSoftReference(){
        Object obj = new Object();
        SoftReference<Object> sf = new SoftReference<>(obj);
        obj = null;
        System.out.println(sf.get());
    }

    static void testWeakReference(){
        Object obj = new Object();
        WeakReference<Object> sf = new WeakReference<Object>(obj);
        obj = null;
        System.out.println(sf.get());
        System.out.println(sf.isEnqueued());
    }

    static void testPhantomReference(){
        Object obj = new Object();
        PhantomReference<Object> sf = new PhantomReference<Object>(obj, null);
        obj = null;
        System.out.println(sf.get());
        System.out.println(sf.isEnqueued());
    }

    public static void main(String[] args) {
        TestReference.testSoftReference();
        TestReference.testWeakReference();
        TestReference.testPhantomReference();

    }
}
