package com.lsm.thread;


/**  
 * @Description: 编写一个 Java 程序实现多线程，在线程中输出线程的名字，隔 300 毫秒输出一次，共输出 20 次。 （p202
 * @author: 
 * @date:   2018年12月12日 下午7:52:41   
 */
public class ThreaPrintName {

	
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new ThreadDemo(),"T1");
		t1.start();
		Thread t2 = new Thread(new ThreadDemo(),"T2");
		t2.start();
		Thread t3 = new Thread(new ThreadDemo(),"T3");
		t3.start();
		Thread t4 = new Thread(new ThreadDemo(),"T4");
		t4.start();
		/*new ThreadDemo1("t1").start();
		new ThreadDemo1("t2").start();
		new ThreadDemo1("t3").start();*/
		
		
	}

}


class ThreadDemo implements Runnable{


	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	
}

class ThreadDemo1 extends Thread {
	public ThreadDemo1(String str) {
		super(str);
	}

	public void run() {
		for (int i = 0; i < 20; i++) {
			System.out.println("  " + this.getName());
			try {
				sleep(300);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
				return;
			}
		}
	}
}





