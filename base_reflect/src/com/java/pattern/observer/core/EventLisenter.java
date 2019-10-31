package com.java.pattern.observer.core;

import java.lang.reflect.Method;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: lsm
 * @description: 事件的注册和监听
 * @create: 2019-09-27 11:16
 */
public class EventLisenter {

    // 注册器
    protected Map<Enum, Event> events = new HashMap<>();

    public void addLisenter(Enum eventType, Object target, Method callback) {

        // 注册事件
        // 用反射调用这个方法
        events.put(eventType, new Event(target, callback));
    }

    private void trigger(Event e) {
        e.setSource(this);
        e.setTime(Instant.now().toEpochMilli());

        try {
            e.getCallback().invoke(e.getTarget(), e);
        } catch (Exception e1) {
            e1.printStackTrace();
        }

    }

    protected void trigger(Enum call) {
        if (!this.events.containsKey(call)) {
            return;
        }
        trigger(this.events.get(call).setTrigger(call.toString()));
    }


}
