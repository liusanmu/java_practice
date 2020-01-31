package com.lsm.thread.synchronize;
/**
 * 同步线程
 */
class StaticSyncThread implements Runnable {
   private static int count;
 
   public StaticSyncThread() {
      count = 0;
   }
 
   public synchronized static void method() {
      for (int i = 0; i < 5; i ++) {
         try {
            System.out.println(Thread.currentThread().getName() + ":" + (count++));
            Thread.sleep(100);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }
    @Override 
   public synchronized void run() {
      method();
   }
    
    public static void main(String[] args) {
    	StaticSyncThread syncThread1 = new StaticSyncThread();
    	StaticSyncThread syncThread2 = new StaticSyncThread();
    	Thread thread1 = new Thread(syncThread1, "SyncThread1");
    	Thread thread2 = new Thread(syncThread2, "SyncThread2");
    	thread1.start();
    	thread2.start();
	}
//    syncThread1和syncThread2是SyncThread的两个对象，但在thread1和thread2并发执行时却保持了线程同步。
//    这是因为run中调用了静态方法method，而静态方法是属于类的，所以syncThread1和syncThread2相当于用了同一把锁。
//    这与Demo1是不同的。
}
//A. 无论synchronized关键字加在方法上还是对象上，如果它作用的对象是非静态的，
//     则它取得的锁是对象；如果synchronized作用的对象是一个静态方法或一个类，则它取得的锁是对类，该类所有的对象同一把锁。
//B. 每个对象只有一个锁（lock）与之相关联，谁拿到这个锁谁就可以运行它所控制的那段代码。
//C. 实现同步是要很大的系统开销作为代价的，甚至可能造成死锁，所以尽量避免无谓的同步控制。
