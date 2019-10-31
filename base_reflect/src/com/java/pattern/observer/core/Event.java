package com.java.pattern.observer.core;

import java.lang.reflect.Method;

/**
 * @author: lsm
 * @description: 事件
 * @create: 2019-09-27 11:12
 */
public class Event {
    //事件源
    private Object source;

    //通知目标
    private Object target;

    //回调
    private Method callback;

    //触发
    private String trigger;

    private Long time;


    public Event(Object target, Method callback) {
        this.target = target;
        this.callback = callback;
    }

    @Override
    public String toString() {
        return "Event{" +
                "source=" + source +
                ", target=" + target +
                ", callback=" + callback +
                ", time=" + time +
                '}';
    }


    public String getTrigger() {
        return trigger;
    }

    Event setTrigger(String trigger) {
        this.trigger = trigger;
        return this;
    }

    public Object getSource() {
        return source;
    }

    Event setSource(Object source) {
        this.source = source;
        return this;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Method getCallback() {
        return callback;
    }

    public void setCallback(Method callback) {
        this.callback = callback;
    }

    public Long getTime() {
        return time;
    }

    Event setTime(Long time) {
        this.time = time;
        return this;
    }
}
