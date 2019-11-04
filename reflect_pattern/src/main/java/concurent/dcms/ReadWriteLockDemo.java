package concurent.dcms;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: ls
 * @description:
 * @create: 2019-11-04 19:56
 */
public class ReadWriteLockDemo {

    public static void main(String[] args) {

        MyCache myCache = new MyCache();

        for (int i = 0; i < 5; i++) {
            // lambda中不允许变量
            final int temp = i;
            new Thread(()->{
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                myCache.put(temp + "", temp + "");
            } ,String.valueOf(i)).start();
        }

        for (int i = 0; i < 5; i++) {
            // lambda中不允许变量
            final int temp = i;
            new Thread(()->{
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                myCache.get(temp + "");
            } ,String.valueOf(i)).start();
        }
    }

}


class MyCache{

    private Map<String, Object> map = new HashMap<>();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    public void put(String key, Object value){
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " \t 写入数据" + key);

            map.put(key, value);

            System.out.println(Thread.currentThread().getName() + " \t 写入完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }


    public void get(String key){
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " \t 开始读取数据" );
            Object o = map.get(key);
            System.out.println(Thread.currentThread().getName() + " \t 读取完成" + key +":"+ o );
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }

    }

}