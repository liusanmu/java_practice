package com.java.pattern.strategy.order;

import org.springframework.stereotype.Component;

/**
 * @author: lsm
 * @description:
 * @create: 2019-09-27 16:39
 */
@Component
@HandlerType("2")
public class GroupHandler extends AbstractHandler{

    @Override
    public String handle(OrderDto orderDto) {

        return "处理团购订单";
    }

}
