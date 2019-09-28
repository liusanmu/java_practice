package com.java.pattern.strategy.order;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: lsm
 * @description: https://juejin.im/post/5c551122e51d457fcc5a9790
 * @create: 2019-09-27 16:22
 */
@Data
public class OrderDto {
    private String code;
    private BigDecimal price;

    /**
     * 订单类型
     * 1.普通订单
     * 2.团购订单
     * 3.促销订单*
     */
    private String type;
}
