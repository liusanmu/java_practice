package concurent.demo01;

import java.util.concurrent.LinkedBlockingQueue;

/**
 @author: ls
 @description:
 @create: 2019-09-17 9:40
 */
public class PrintProcessor extends Thread implements RequestProcessor {

    LinkedBlockingQueue<Request> linkedBlockingQueue =  new LinkedBlockingQueue<>();

    // final 只能赋值一次
    private final RequestProcessor nextProcessor ;

    public PrintProcessor(RequestProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    @Override
    public void run() {
        while(true){
            try {
                Request request=linkedBlockingQueue.take();
                System.out.println("print data:"+request);
                nextProcessor.processorRequest(request);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void processorRequest(Request request) {
        linkedBlockingQueue.add(request);
    }
}
