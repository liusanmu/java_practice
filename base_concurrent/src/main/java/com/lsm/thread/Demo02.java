package com.lsm.thread;
/**  
 * @Description: //如果调用run()方法，则是直接调用pong(),然后打印Ping;    pongping
 * 			如果调用start()方法,则是先另外开启个线程，然后另一个线程在执行run()方法的pong()方法，
 * 				当然开启线程需要是时间所以先打印了ping    pingpong
 * @author: lsm
 * @date: 2018年12月29日 下午3:38:00   
 */
public class Demo02 {
	public static void main(String args[]) {
        Thread t = new Thread() {
            public void run() {
                pong();
            }
        };
        //t.start();
         t.run();
        System.out.print("ping");

    }

    static void pong() {
        System.out.print("pong");
    }
}
