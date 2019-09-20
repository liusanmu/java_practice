package com.java.pattern.singleton.lazy;

/**
 * @author: lsm
 * @description: 饿汉式线程安全之
 * 外部类初次加载，会初始化静态变量、静态代码块、静态方法，但不会加载内部类和静态内部类。
 * 实例化外部类，调用外部类的静态方法、静态变量，则内部类必须先进行加载，但只加载一次。
 * 直接调用静态内部类时，外部类不会加载。
 * @create: 2019-09-20 16:34
 */
public class LazySingleton2 {

    private LazySingleton2(){
    }

    public static final LazySingleton2 getInstance(){

        return LazyHolder.LAZY_SINGLETON_2;
    }

    private static class LazyHolder{

        private static final LazySingleton2  LAZY_SINGLETON_2 = new LazySingleton2();

    }

}
