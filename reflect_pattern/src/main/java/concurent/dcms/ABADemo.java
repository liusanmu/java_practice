package concurent.dcms;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author: ls
 * @description:
 * @create: 2019-10-31 19:02
 */
public class ABADemo {
    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
    static AtomicStampedReference<Integer> atomicStampeReference = new AtomicStampedReference<>(100, 1);
    public static void main(String[] args)  {
        System.out.println("===============ABA问题===============");
         new Thread(() -> {
             atomicReference.compareAndSet(100, 101);
             atomicReference.compareAndSet(101, 100);
          }, String.valueOf("t1")).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
             System.out.println("atomicReference.compareAndSet(100, 101) = " + atomicReference.compareAndSet(100, 101)+atomicReference.get());
         }, String.valueOf("t2")).start();




         new Thread(() -> {
             System.out.println("===============ABA问题的结局===============");
             int stamp = atomicStampeReference.getStamp();
             System.out.println(Thread.currentThread().getName() + "\t第一次版本号："+ stamp);
             try {
                 // 暂定t3线程1s
                 TimeUnit.SECONDS.sleep(1);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             atomicStampeReference.compareAndSet(100,101,atomicStampeReference.getStamp(),atomicStampeReference.getStamp()+1 );
             System.out.println(Thread.currentThread().getName() + "\t第二次版本号："+ stamp);
             atomicStampeReference.compareAndSet(101,100,atomicStampeReference.getStamp(),atomicStampeReference.getStamp()+1 );
             System.out.println(Thread.currentThread().getName() + "\t第三次版本号："+ stamp);

             System.out.println();
         }, String.valueOf("t3")).start();

        new Thread(() -> {
            int stamp = atomicStampeReference.getStamp();
            System.out.println(Thread.currentThread().getName() + "\t第一次版本号："+ stamp);
            try {
                // 暂定3s t4线程，保障t3完成一次ABA操作
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean b = atomicStampeReference.compareAndSet(100, 2019, stamp, stamp + 1);

            System.out.println(Thread.currentThread().getName() + "\t修改成功与否："+b+"当前最新实际版本号："+ atomicStampeReference.getStamp());
            System.out.println(Thread.currentThread().getName() + "\t当前最新值："+ atomicStampeReference.getStamp());

            System.out.println();
        }, String.valueOf("t4")).start();


    }
}
