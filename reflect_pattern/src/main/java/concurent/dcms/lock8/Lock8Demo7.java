package concurent.dcms.lock8;

/**
 * @author: lsm
 * @description: 八锁演示
 * @create: 2019-11-01 21:12
 */

/**
 * 一个静态同步方法，一个普通同步方法，同一部手机，请问是先打印邮件还是短信
    一个静态同步方法，一个普通同步方法，两部手机，请问是先打印邮件还是短信
 */
public class Lock8Demo7 {

    public static void main(String[] args) {
        Phone7 phone = new Phone7();
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


class Phone7{

    public static synchronized void sendMsg() throws Exception{
        System.out.println("sendMsg**************");
    }

    public synchronized void sendEmail() throws Exception{
        System.out.println("sendEmail**************");
    }
}