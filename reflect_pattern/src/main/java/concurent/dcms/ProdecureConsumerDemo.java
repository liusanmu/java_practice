package concurent.dcms;

/**
 * @author: lsm
 * @description:
 * @create: 2019-11-03 12:03
 * 使用synchronized系列完成
 * 题：现在两个线程，现在操作初始值为零的变量，实现一个线程对该变量加一，一个线程对该变量减一，操作10轮
 * 多线程交互关键：
 * 1.高内聚低耦合前提下，线程操作资源类
 * 2.判断，干活，通知
 * 3.防止虚假唤醒(多线程交互种判断必须要用while,不能用if)
 */
public class ProdecureConsumerDemo {
    public static void main(String[] args) {
        //资源类
        Aircondition ad = new Aircondition();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                ad.increment();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                ad.decrement();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                ad.increment();
            }
        }, "C").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                ad.decrement();
            }
        }, "D").start();
    }
}

class Aircondition {

    private int num = 0;

    public synchronized void increment() {
        // 判断
        // if (num != 0){
        while (num != 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 干活
        num++;
        System.out.println(Thread.currentThread().getName() + ":" + num);
        // 通知
        this.notifyAll();


    }

    public synchronized void decrement() {
        //if (num == 0){
        while (num == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 干活
        num--;
        System.out.println(Thread.currentThread().getName() + ":" + num);
        // 通知
        this.notifyAll();
    }

}


