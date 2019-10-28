package com.lsm.concurent.dcms;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author: lsm
 * @description:
 * @create: 2019-10-27 17:50
 */
public class VolatileDemo {

    private static ExecutorService executorService = Executors.newFixedThreadPool(20);

    public static void main(String[] args) {
        Mydata mydata = new Mydata();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "1");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mydata.addT060();

            while (mydata.num == 0){

            }
            System.out.println(Thread.currentThread().getName() + "2");
        },"A").start();

    /*    for (int i = 0; i < 5; i++) {
            executorService.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mydata.addT060();
            } );
        }*/

    }
}


class Mydata{
    int num = 0;

    public void addT060(){
        this.num = 60;
    }
}
