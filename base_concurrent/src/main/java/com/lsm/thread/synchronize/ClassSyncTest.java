package com.lsm.thread.synchronize;
/**
 * 其效果和StaticSyncThread.java是一样的，synchronized作用于一个类T时，是给这个类T加锁，T的所有对象用的是同一把锁。
 * @author lsm
 *
 */
public class ClassSyncTest {

}

class Sync implements Runnable {
	   private static int count;
	 
	   public Sync() {
	      count = 0;
	   }
	 
	   public static void method() {
	      synchronized(SyncThread.class) {
	         for (int i = 0; i < 5; i ++) {
	            try {
	               System.out.println(Thread.currentThread().getName() + ":" + (count++));
	               Thread.sleep(100);
	            } catch (InterruptedException e) {
	               e.printStackTrace();
	            }
	         }
	      }
	   }
	 
	   public synchronized void run() {
	      method();
	   }
	}