package com.lsm.thread;

/**
 * @Description: 设计4个线程，其中两个线程每次对j增加1，另外两个线程对j每次减少1
 * @author: lsm
 * @date: 2018年12月29日 下午1:44:23   
 */
public class Demo01 {

	public static void main(String[] args) {
		OpThread obj = new OpThread();
		/*Thread t1 = new Thread(new Increase(obj));
		Thread t2 = new Thread(new Decrease(obj));
		Thread t3 = new Thread(new Increase(obj));
		Thread t4 = new Thread(new Decrease(obj));
		t1.start();
		t2.start();
		t3.start();
		t4.start();*/
		for (int i = 0; i < 2; i++){
			Thread inc = new Thread(new Increase(obj));
			Thread dec = new Thread(new Decrease(obj));
			inc.start();
			dec.start();
			

		}
		
	}

}

class Increase implements Runnable{
    private OpThread obj; 
	public Increase(OpThread obj) {
	this.obj = obj;
	}
	@Override
	public void run() {
		this.obj.inc();
	}
	
}

class Decrease implements Runnable{
	private OpThread obj;
	
	public Decrease(OpThread obj) {
		this.obj = obj;
	}
	
	@Override
	public void run() {
		this.obj.dec();
	}
	
}


class OpThread{
    private int j;
	public synchronized void inc() {
		for (int i = 0; i < 50; i++) {
			j++;
			System.out.println(Thread.currentThread().getName() + " inc " + j);
		}
	}

	public synchronized void dec() {
		for (int i = 0; i < 50; i++) {
			j--;
			System.out.println(Thread.currentThread().getName()+ " dec " + j);
		}
	}
	
}
