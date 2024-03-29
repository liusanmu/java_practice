package com.lsm.thread.synchronize;
/**  
这时创建了两个SyncThread的对象syncThread1和syncThread2，线程thread1执行的是syncThread1对象中的synchronized
代码(run)，而线程thread2执行的是syncThread2对象中的synchronized代码(run)；我们知道synchronized锁定的是对象，
这时会有两把锁分别锁定syncThread1对象和syncThread2对象，而这两把锁是互不干扰的，不形成互斥，所以两个线程可以同时执行。
 */
public class SyncThread2 implements Runnable{
	private static int count;
	
	public SyncThread2() {
		count = 0;
	}

	@Override
	public void run() {
		synchronized (this) { //换成SyncThread2.class则线程同步了
			for (int i = 0; i < 5; i++) {
				try {
					System.out.println(Thread.currentThread().getName() + ":" + (count++));
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}
		
	}
	
	public int getCount(){
		return count;
	}
	
	public static void main(String[] args) {
		SyncThread syncThread1 = new SyncThread();
		SyncThread syncThread2 = new SyncThread();
		Thread thread1 = new Thread(syncThread1, "SyncThread1");
		Thread thread2 = new Thread(syncThread2, "SyncThread2");
		thread1.start();
		thread2.start();
	}
}
/*
SyncThread2:0
SyncThread1:1
SyncThread2:2
SyncThread1:2
SyncThread1:3
SyncThread2:4
SyncThread2:5
SyncThread1:6
SyncThread1:8
SyncThread2:7


*/