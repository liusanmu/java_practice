package com.lsm.thread;
/**  
 * @Description: 通过置标记为相反的布尔值，来终止线程  标记法
 * @author: liusen
 * @date:   2018年12月7日 下午4:53:56   
 * @version V2.0
 */
public class InterruptThread {
/**
 * sleep:在指定时间内让当前正在执行的线程暂停执行，但不会释放“锁标志”。不推荐使用。
 * 		 sleep()使当前线程进入阻塞状态，在指定时间内不会执行。 通过Thread.sleep()调用
 *
 *yield方法: 暂停当前正在执行的线程对象。
            yield()只是使当前线程重新回到可执行状态，所以执行yield()的线程有可能在进入到可执行状态后马上又被执行。
            yield()只能使同优先级或更高优先级的线程有执行的机会。   通过Thread.yield调用
            
 *join方法：join()是由线程对象来调用。
 *
 *wait()和notify()、notifyAll()  这三个方法都是java.lang.Object的方法! 
 *wait()方法使当前线程暂停执行并释放对象锁标志，让其他线程可以进入Synchronized数据块，当前线程被放入对象等待池中。
 */
	 public static void main(String args[]) throws InterruptedException {
	        ThreadTest t1=new ThreadTest();
	        t1.start();
	        Thread.sleep(1000);
	        System.out.println(System.currentTimeMillis());
	        t1.stopMe();

	    }
	    static class ThreadTest extends Thread{
	        private boolean stopMe = false;

	        public void stopMe() {
	            this.stopMe = true;
	        }

	        @Override
	        public void run() {
	            while(true){
	                if(stopMe){
	                    System.out.println("interrupt!");
	                    break;
	                }
	                try {
	                    System.out.println("t1 sleep");
	                    Thread.sleep(5000);
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	                Thread.yield();
	            }
	            System.out.println(System.currentTimeMillis());
	        }
	    }
		
}
