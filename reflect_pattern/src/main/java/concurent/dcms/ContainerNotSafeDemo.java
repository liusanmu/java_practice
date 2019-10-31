package concurent.dcms;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: lsm
 * @description: 演示ArrayList的并发修改异常
 * java.util.ConcurrentModificationException
 * @create: 2019-10-31 8:50
 */
public class ContainerNotSafeDemo {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        Lock lock = new ReentrantLock();
        for (int i = 1; i < 30; i++) {
            new Thread(() -> {
                try {
                    lock.lock();
                    // beginIndex - 开始处的索引（包括）-->endindex 结尾处索引（不包括）。
                    list.add(UUID.randomUUID().toString().substring(0, 8));
                    System.out.println(list);
                } finally {
                    lock.unlock();
                }
            }, String.valueOf(i)).start();

        }

    }

}