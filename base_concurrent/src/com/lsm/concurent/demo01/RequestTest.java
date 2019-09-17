package com.lsm.concurent.demo01;/**
 * @author: lsm
 * @description:
 * @create: 2019-09-17 9:53
 */

/**
 @author: ls
 @description:
 @create: 2019-09-17 9:53
 */
public class RequestTest {
    PrintProcessor printProcessor;

    public RequestTest() {
        SaveProcessor saveProcessor = new SaveProcessor();
        saveProcessor.start();
        printProcessor=new PrintProcessor(saveProcessor);
        printProcessor.start();
    }

    public static void main(String[] args) {
        Request request=new Request();
        request.setName("mic");
        new RequestTest().doTest(request);
    }

    public void doTest(Request request){

        printProcessor.processorRequest(request);

    }


}
