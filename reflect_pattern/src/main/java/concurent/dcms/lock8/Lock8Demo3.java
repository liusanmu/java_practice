package concurent.dcms.lock8;

/**
 * @author: lsm
 * @description: 八锁演示
 * @create: 2019-11-01 21:12
 */

import java.util.concurrent.TimeUnit;

/**
 * 新增一个普通的sayHello方法，请问先打印邮件还是hello
 * sayHello**************
 * sendEmail**************
 */
public class Lock8Demo3 {

    public static void main(String[] args) {
        Phone3 phone = new Phone3();
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
                phone.sayHello();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"B").start();

    }

}


class Phone3{

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