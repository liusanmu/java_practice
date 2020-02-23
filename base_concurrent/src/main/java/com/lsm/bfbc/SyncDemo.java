package com.lsm.bfbc;

import javafx.print.Collation;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: lsm
 * @description:
 * @create: 2020-02-01 11:08
 */
public class SyncDemo {

    // demo()和demo2()效果一样
    public synchronized void demo() { }

    public void demo2() {
        //TODO
        synchronized (this) { }
        //TODO
    }

    // demo3() demo4() demo5()一样
    Object lock = new Object();

    public synchronized static void demo3() { }

    public void demo4() {
        synchronized (SyncDemo.class) {

        }
    }

    public void demo5() {
        synchronized (lock) {

        }
    }

    public static void main(String[] args) {
        SyncDemo syncDemo = new SyncDemo();
        SyncDemo syncDemo1 = new SyncDemo();
        System.out.println(Objects.equals(syncDemo,syncDemo1));
    }
}
