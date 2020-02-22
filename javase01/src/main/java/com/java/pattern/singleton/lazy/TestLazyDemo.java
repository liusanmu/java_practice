package com.java.pattern.singleton.lazy;


import java.time.Instant;
import java.util.concurrent.CountDownLatch;

/*
 * CountDownLatch ：闭锁，在完成某些运算是，只有其他所有线程的运算全部完成，当前运算才继续执行
 */
public class TestLazyDemo {

    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(500);
        LatchDemo ld = new LatchDemo(latch);

        long start = System.currentTimeMillis();

        for (int i = 0; i < 500; i++ ) {
            new Thread(ld).start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
        }

        long end = System.currentTimeMillis();

        System.out.println("耗费时间为：" + (end - start));
    }

}

class LatchDemo implements Runnable {

    private CountDownLatch latch;

    public LatchDemo(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {

        try {


                LazySingleton instance = LazySingleton.getInstance();
                System.out.println(Instant.now().toEpochMilli() + " : " + instance);

        } finally {
            latch.countDown();
        }

    }

}