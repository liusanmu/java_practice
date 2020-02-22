package com.java.pattern.singleton.lazy;

import org.junit.Test;

import java.time.Instant;
import java.util.concurrent.CountDownLatch;

/**
 * @author: lsm
 * @description:
 * @create: 2019-09-20 16:37
 */
public class TestLazy {

   @Test
   public void test1() {

      int count = 1;
      final CountDownLatch latch = new CountDownLatch(count);

      long start = System.currentTimeMillis();

      for (int i = 0; i < count; i++) {
         new Thread(()->{
            try {
               latch.await();
               LazySingleton2 instance = LazySingleton2.getInstance();
               System.out.println(Instant.now().toEpochMilli() + " : " + instance);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }

         }).start();

         latch.countDown();
         System.out.println(count);
      }

      try {
         // 使当前线程在锁存器倒计数至零之前一直等待，除非线程被中断。
         latch.await();
         long end = System.currentTimeMillis();
         System.out.println("耗费时间为：" + (end - start));
      } catch (InterruptedException e) {
         e.printStackTrace();
      }


   }
   

}
