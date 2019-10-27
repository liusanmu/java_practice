package concurent.demo02;

/**
 * @author: lsm
 * @description:
 * @create: 2019-09-18 11:12
 */
public class Ticket implements Runnable {
            private volatile static  int ticket = 100;
            /*
     * 执行卖票操作
     */
            @Override
    public void run() {
                //每个窗口卖票的操作
                //窗口 永远开启
                while (true) {
                    if (ticket > 0) {//有票 可以卖
                        //出票操作
                        //使用sleep模拟一下出票时间
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            // TODO Auto‐generated catch block
                            e.printStackTrace();
                        }
                        //获取当前线程对象的名字
                        String name = Thread.currentThread().getName();
                        System.out.println(name + "正在卖:" + ticket--);
                    }
                }
            }


    public static void main(String[] args) {    
        //创建线程任务对象
        Ticket ticket = new Ticket();        
        //创建三个窗口对象
        Thread t1 = new Thread(ticket, "窗口1");        
        Thread t2 = new Thread(ticket, "窗口2");        
        Thread t3 = new Thread(ticket, "窗口3");        
       
        //同时卖票
        t1.start();        
        t2.start();        
        t3.start();        
    }
}