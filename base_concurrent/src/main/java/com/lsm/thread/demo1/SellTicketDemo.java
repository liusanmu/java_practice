package com.lsm.thread.demo1;


/**  
 * @Description: SellTicketDemo.java
 * @author: liusen
 * @date:   2019年4月26日 上午10:30:14   
 */
public  class SellTicketDemo {

	public static void main(String[] args) {
		Ticket ticket = new Ticket();
		new Thread(ticket,"窗口一").start();
		new Thread(ticket,"窗口二").start();
		new Thread(ticket,"窗口三").start();
		new Thread(ticket,"窗口四").start();
	}
}


class Ticket implements Runnable{
	
	private int num = 10;
	Object lock = new Object();
	
	@Override
	public void run() {
		while(true){
			synchronized (Ticket.class) {
			if (num>0) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			
					System.out.println(Thread.currentThread().getName() + "正在卖第" + num--);
				}
				
			}
			
		}
		
	}

}