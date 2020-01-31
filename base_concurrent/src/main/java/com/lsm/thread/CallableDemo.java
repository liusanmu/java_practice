package com.lsm.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**  
 * @Description: CallableDemo.java
 * @author: liusen
 * @date:   2019年4月24日 下午3:13:40   
 */
public class CallableDemo {
	
	public static void main(String[] args) throws Exception {
		 Callable<String> callable = new Callable<String>() {
	            @Override
	            public String call() throws Exception {
	                System.out.println("线程启动"+Thread.currentThread().getName());
	                return "aaa";
	            }
	        };
	        FutureTask<String> ft = new FutureTask<String>(callable);
	        for (int i = 0; i < 100; i++) {
	            System.out.println(Thread.currentThread().getName() + " " + i);
	            if (i == 30) {
	                Thread thread = new Thread(ft);   //FutureTask对象作为Thread对象的target创建新的线程
	                thread.start();                      //线程进入到就绪状态
	            }
	        }
	      //  new Thread(ft).start();
	        String s = ft.get();
	        System.out.println(s);
	
	}

}
