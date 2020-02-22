package com.java.pattern.strategy.order;

/**
 * @author: lsm
 * @description:
 * @create: 2019-09-27 16:39
 */
//@Compontent
//@HandlerType("1")
public class NormalHandler extends AbstractHandler {

    @Override
    public String handle(OrderDto orderDto) {

        return "处理普通订单";
    }

}
