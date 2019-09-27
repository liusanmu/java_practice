package com.java.pattern.strategy.pay;

/**
 * @author: lsm
 * @description:
 * @create: 2019-09-26 18:03
 */
public class PayState {

    private int code;
    private Object data;
    private String msg;

    public PayState(int code, String msg, Object data) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public String toString() {
        return ("支付状态：[" + code + "]," + msg + ",交易详情：" + data);
    }
}
