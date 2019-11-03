package concurent.dcms.lock8;

/**
 * @author: lsm
 * @description: 八锁演示
 * @create: 2019-11-01 21:12
 */

import java.util.concurrent.TimeUnit;

/**
 * 二个静态同步方法，同一个手机，先打印邮件还是短信
 sendEmail**************
 sendMsg**************
 */
public class Lock8Demo5 {

    public static void main(String[] args) {
        Phone4 p1 = new Phone4();

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
                p1.sendMsg();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"B").start();

    }

}


class Phone5{

    public static synchronized void sendEmail() throws Exception{
        TimeUnit.SECONDS.sleep(4);
        System.out.println("sendEmail**************");
    }

    public static synchronized void sendMsg() throws Exception{

        System.out.println("sendMsg**************");
    }

    public void sayHello(){
        System.out.println("sayHello**************");
    }


}

