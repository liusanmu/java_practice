package com.lsm.concurent.demo02;

/**
 * @author: lsm
 * @description: 原子性
 * @create: 2019-09-18 9:15
 */
public class AtomicDemo {

    private static int count = 0;

    public static void inc(){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<1000;i++){
            new Thread(AtomicDemo::inc).start();
        }
         Thread.sleep(4000);
        System.out.println("y运行结果："+count);
    }

}
