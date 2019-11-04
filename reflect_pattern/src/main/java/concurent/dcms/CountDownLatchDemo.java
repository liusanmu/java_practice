package concurent.dcms;

import java.util.concurrent.CountDownLatch;

/**
 * @author: lsm
 * @description:
 * @create: 2019-11-03 21:19
 */
public class CountDownLatchDemo {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 0; i < 6; i++) {
             new Thread(() -> {
                 System.out.println(Thread.currentThread().getName()+ "离开了教室");
                countDownLatch.countDown();
              }, String.valueOf(i)).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "最后一个人离开了教室");
    }


}
