package concurent.demo01;/**
 * @author: lsm
 * @description:
 * @create: 2019-09-17 9:40
 */

import java.util.concurrent.LinkedBlockingQueue;

/**
 @author: ls
 @description:
 @create: 2019-09-17 9:40
 */
public class SaveProcessor extends Thread implements RequestProcessor {

    LinkedBlockingQueue<Request> linkedBlockingQueue =  new LinkedBlockingQueue<>();

    @Override
    public void processorRequest(Request request) {
        linkedBlockingQueue.add(request);
    }

    @Override
    public void run() {
        while (true){
            // 获取并移除此队列的头部，在元素变得可用之前一直等待 。queue的长度 == 0 的时候，一直阻塞
            Request take = null;
            try {
                take = linkedBlockingQueue.take();
                System.out.println("save request:" + take);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
