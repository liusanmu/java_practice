package concurent.dcms;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author: lsm
 * @description:信号量
 * @create: 2019-11-06 0:33
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        // 模拟资源类，当前有3个车位
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 6; i++) {

            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "\t抢到了车位");

                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName() + "\t离开了车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }

            }, String.valueOf(i)).start();

        }

    }
}
