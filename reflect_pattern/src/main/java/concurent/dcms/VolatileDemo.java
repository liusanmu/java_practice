package concurent.dcms;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: lsm
 * @description:
 * @create: 2019-10-27 17:50
 */
public class VolatileDemo {

    private static ExecutorService executorService = Executors.newFixedThreadPool(20);

    // 验证可见性
    /*public static void main(String[] args) {
        Mydata mydata = new Mydata();
       new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "1");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mydata.addT060();
            System.out.println(Thread.currentThread().getName() + "update");

        },"A").start();
        while (mydata.num == 0){
        }
        System.out.println(Thread.currentThread().getName() + "2");
    }*/
    // 验证不能保证原子性(已经volatile修饰了)
    public static void main(String[] args) {
        Mydata mydata = new Mydata();
        for (int i = 1; i <= 20; i++) {

            new Thread(()->{
                for (int j = 1; j <= 1000; j++) {
                    mydata.addPlus();
                    mydata.addPlusByAtomic();
                }
            }, String.valueOf(i)).start();
        }

        //暂停一会儿线程
        //需要等待上面20个线程全部计算完成后，由main方法取出结果值
      /*  try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        //必定有2个线程 main和gc
        while (Thread.activeCount() > 2){
            //礼让线程，本线程不执行
            Thread.yield();
        }

        System.out.println("finally print:" + mydata.num);
        System.out.println("finally print by atomic:" + mydata.atomicInteger);
    }
}


class Mydata{
    volatile int num = 0;

    public void addT060(){
        this.num = 60;
    }

    //
    public void addPlus(){
        num++;
    }

    AtomicInteger atomicInteger = new AtomicInteger(0);
    public void addPlusByAtomic(){
        atomicInteger.getAndIncrement();
    }

}
 /*
executorService.execute(() -> {
        System.out.println(Thread.currentThread().getName() + "1");
        try {
        TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
        e.printStackTrace();
        }
        mydata.addT060();
        System.out.println(Thread.currentThread().getName() + "update");
        });

        while (mydata.num == 0){

        }
        System.out.println(Thread.currentThread().getName() + "2");
       for (int i = 0; i < 5; i++) {
            executorService.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mydata.addT060();
            } );
        }*/
