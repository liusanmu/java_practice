package concurent.dcms;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: lsm
 * @description:d多个线程按照顺序调用，实现A -> B -> C三个线程启动
 * 要求如下：
 * AA打印5此，BB打印10次， CC打印15次 ，共计10轮
 * @create: 2019-11-05 23:53
 */
public class ConditionDemo {

    public static void main(String[] args) {
        ShareData shareData = new ShareData();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                shareData.print5();
            }
        }, "A").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                shareData.print10();
            }
        }, "B").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                shareData.print15();
            }
        }, "C").start();
    }
}

class ShareData {
    private int number = 1; // A:1 B:2 C:3
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void print5() {
        lock.lock();
        try {
            while (number != 1) {
                try {
                    c1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() +"\t"+ i);
            }
            number = 2;
            c2.signal();

        } finally {
            lock.unlock();
        }
    }

    public void print10() {
        lock.lock();
        try {
            while (number != 2) {
                try {
                    c2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() +"\t"+ i);
            }
            number = 3;
            c3.signal();

        } finally {
            lock.unlock();
        }
    }

    public void print15() {
        lock.lock();
        try {
            while (number != 3) {
                try {
                    c3.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName() +"\t"+ i);
            }
            number = 1;
            c1.signal();

        } finally {
            lock.unlock();
        }
    }

}

