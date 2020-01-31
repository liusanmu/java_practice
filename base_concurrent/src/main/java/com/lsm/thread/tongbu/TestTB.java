package com.lsm.thread.tongbu;

/**
 * @Description: TestTB.java
 * @author: liusen
 * @date: 2019年4月12日 下午1:44:19
 */
public class TestTB {

	public static void main(String[] args) {
		final Bussiness bussiness = new Bussiness();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 3; i++) {
					bussiness.subMethod();
				}
			}
		}).start();
		
		// 主线程
		for (int i = 0; i < 3; i++) {
			bussiness.mainMethod();
		}

	}
	
}

class Bussiness {

	private boolean subFlag = true;

	public synchronized void mainMethod() {
		while (subFlag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName()
					+ " : main thread running loop count --" + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		subFlag = true;
		notify();
	}

	/**
	 * 
	 */
	public synchronized void subMethod() {
		while (!subFlag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		for (int i = 0; i < 10; i++) {
			System.err.println(Thread.currentThread().getName()
					+ " : sub thread running loop count -- " + i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		subFlag = false;
		notify();
	}

}