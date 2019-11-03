package concurent.dcms.lock8;

/**
 * @author: lsm
 * @description: 八锁演示
 * @create: 2019-11-01 21:12
 */

import java.util.concurrent.TimeUnit;

/**
 * 二部手机，请问先打印邮件还是短信
 * sendMsg**************
 * sendEmail**************
 */
public class Lock8Demo4 {

    public static void main(String[] args) {
        Phone4 p1 = new Phone4();
        Phone4 p2 = new Phone4();

        new Thread(()->{
            try {
                p1.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"A").start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            try {
                p2.sendMsg();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"B").start();

    }

}


class Phone4{

    public synchronized void sendEmail() throws Exception{
        TimeUnit.SECONDS.sleep(4);
        System.out.println("sendEmail**************");
    }

    public synchronized void sendMsg() throws Exception{

        System.out.println("sendMsg**************");
    }

    public void sayHello(){
        System.out.println("sayHello**************");
    }


}