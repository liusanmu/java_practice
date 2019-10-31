package com.java.pattern.strategy.order;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: lsm
 * @description:
 * @create: 2019-09-27 16:27
 */
//@Service
public class OrderSerivce implements IOrderService {

    @Autowired
    //  private HandlerConext handlerConext;


    @Override
    public String handle(OrderDto orderDto) {

        // AbstractHandler handler = handlerConext.getInstance(orderDto.getType());

        //return handler.handler(orderDto);
        return null;
    }


    /*@Override
    public String handle(OrderDto orderDto) {
        String type = orderDto.getType();
        if (type.equals("1")) {

            return "普通订单";

        }else if(type.equals("1")) {

            return "团购订单";
        }else if (type.equals("1")) {
            return "促销订单";
        } else{
            return "错误";
        }
    }*/
}
