package concurent.dcms.lock8;

/**
 * @author: lsm
 * @description: 八锁演示
 * @create: 2019-11-01 21:12
 */

import java.util.concurrent.TimeUnit;

/**
 * 暂停四秒种在邮件方法，请问先打印邮件还是短信
 * sendEmail**************
 * sendMsg**************
 */
public class Lock8Demo2 {

    public static void main(String[] args) {
        Phone1 phone = new Phone1();
        new Thread(()->{
            try {
                phone.sendEmail();
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
                phone.sendMsg();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"B").start();

    }

}


class Phone1{

    public synchronized void sendEmail() throws Exception{
        TimeUnit.SECONDS.sleep(4);
        System.out.println("sendEmail**************");
    }
    public synchronized void sendMsg() throws Exception{

        System.out.println("sendMsg**************");
    }


}