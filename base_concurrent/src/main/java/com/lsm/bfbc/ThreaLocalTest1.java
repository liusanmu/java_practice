package com.lsm.bfbc;

/**
 * @author: lsm
 * @description:
 * @create: 2020-02-22 23:47
 */
public class ThreaLocalTest1 {

    static ThreadLocal<Integer> threadLocal =  new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public static void main(String[] args) {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                Integer num = threadLocal.get();
                num = num + 5;
                  System.out.println(Thread.currentThread().getName() +":" + threadLocal.get());
            }, "thread" + i);
            threads[i].start();
        }

        for (Thread thread : threads) {
            System.out.println();
        }
    }
}
