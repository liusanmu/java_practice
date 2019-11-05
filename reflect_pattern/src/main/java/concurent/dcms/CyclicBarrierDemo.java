package concurent.dcms;

import java.time.temporal.TemporalAdjusters;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author: lsm
 * @description:
 * @create: 2019-11-06 0:28
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("第七次了，我执行了");
        });

        for (int i = 0; i < 7; i++) {
            final int temp = i;
            new Thread( ()->{
                System.out.println(temp);
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
