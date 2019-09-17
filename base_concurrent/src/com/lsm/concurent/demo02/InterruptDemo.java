package com.lsm.concurent.demo02;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 @author: ls
 @description:
 @create: 2019-09-17 17:18
 */
public class InterruptDemo {

    private static int i ;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            //调用 thread.interrupt(); 变为true
            while (!Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println(i);


        }, "interruptDemo");
       // System.out.println("1" + thread.isInterrupted());
        thread.start();
       // System.out.println("2" + thread.isInterrupted());
        TimeUnit.SECONDS.sleep(1);
       // System.out.println("3" + thread.isInterrupted());
        thread.interrupt();
        System.out.println("4" + thread.isInterrupted());
// 1true
// 2true
// 3true
// 4true
//685290706
    }


    @Test
    public void test1() throws InterruptedException {
            Thread thred=new Thread(()->{
                while(true){
                    boolean in=Thread.currentThread().isInterrupted();
                    if(in){
                        System.out.println("before:"+in);
                        Thread.interrupted();//设置复位
                        System.out.println("after:"+Thread.currentThread().isInterrupted());
                    }
                }
            });
            thred.start();
            TimeUnit.SECONDS.sleep(1);
            thred.interrupt(); //终端
    }
    
    @Test
    public void test3() throws InterruptedException {
        Thread thread=new Thread(()->{
            while(true){
                try {
                  //  原因是因为单元测试启动的主线程很快就结束了，而子线程确sleep5秒，使得主线程强行打断子线程的sleep,因此抛出异常，
                    //  解决办法是可以在单元测试的最后加上sleep(10*1000),目的是不让主线程在子线程前结束。
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        });
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
        System.out.println("before:"+thread.isInterrupted());
        TimeUnit.SECONDS.sleep(1);
        System.out.println("after:"+thread.isInterrupted());
    
    }
}
