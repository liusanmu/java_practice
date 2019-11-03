package concurent.dcms.lock8;

/**
 * @author: lsm
 * @description: 八锁演示
 * @create: 2019-11-01 21:12
 */

/**
 * 标准访问，请问先打印邮件还是短信
 * sendEmail**************
 * sendMsg**************
 */
public class Lock8Demo1 {

    public static void main(String[] args) {
        Phone phone = new Phone();
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


class Phone{

    public synchronized void sendMsg() throws Exception{
        System.out.println("sendMsg**************");
    }

    public synchronized void sendEmail() throws Exception{
        System.out.println("sendEmail**************");
    }
}