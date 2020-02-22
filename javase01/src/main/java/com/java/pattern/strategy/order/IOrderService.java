package com.java.pattern.strategy.order;

/**
 * @author: lsm
 * @description:
 * @create: 2019-09-27 16:27
 */
public interface IOrderService {

    /**
     * @param orderDto
     * @return
     */
    String handle(OrderDto orderDto);

}
