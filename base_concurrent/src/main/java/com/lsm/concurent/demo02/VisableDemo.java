package com.lsm.concurent.demo02;

import java.util.concurrent.TimeUnit;

/**
 * @author: lsm
 * @description: 可见性
 * @create: 2019-09-17 19:12
 */
public class VisableDemo {
    private volatile static boolean stop = false;
    public static void main(String[] args) throws InterruptedException {

        new Thread(()->{
            int i = 0;
            while (!stop){
                i++;
            }
            System.out.println(i);
        }).start();

        TimeUnit.SECONDS.sleep(3);
        stop = true;
    }
}
