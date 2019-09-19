package com.lsm.reflect.demo1;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: lsm
 * @description:  ArrayList 的动态代理类
 * @create: 2019-09-19 11:09
 */
public class ArryListReflect {

    public static void main(String[] args) {
        final List list = new ArrayList();

        List newProxyInstance = (List) Proxy.newProxyInstance(list.getClass().getClassLoader(), list.getClass().getInterfaces(), (proxy, method, obj) -> method.invoke(list, obj)
        );

        newProxyInstance.add("代理");
        System.out.println(list);
    }

    @Test
    public  void test() {
        final List list = new ArrayList();

        List newProxyInstance = (List)Proxy.newProxyInstance(list.getClass().getClassLoader(), list.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        return method.invoke(list, args);
                    }
                }
        );

        newProxyInstance.add("代理");
        System.out.println(list);
    }
}
