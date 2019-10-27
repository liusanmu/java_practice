package concurent.demo01;

import java.util.concurrent.TimeUnit;

/**
 * @author: lsm
 * @description:
 * @create: 2019-09-17 18:54
 */
public class ThreadSatusDemo {

    public static void main(String[] args) {
        new Thread(()->{
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "timewaiting").start();

        new Thread(() -> {
            while (true) {
                synchronized (ThreadSatusDemo.class) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "waiting").start();


        new Thread(new BlockDemo(),"BlockDemo-0").start();
        new Thread(new BlockDemo(),"BlockDemo-1").start();
    }

    static class BlockDemo extends Thread{

        @Override
        public void run() {
            synchronized (BlockDemo.class){
                while(true){
                    try {
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
