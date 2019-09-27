package com.java.pattern.singleton.lazy;

/**
 * @author: lsm
 * @description: 恶汉式线程不安全
 * @create: 2019-09-20 16:34
 */
public class LazySingleton {

    private LazySingleton() {
    }

    private static LazySingleton lazy = null;

    public static LazySingleton getInstance() {
        if (lazy == null) {
            lazy = new LazySingleton();
        }
        return lazy;
    }

}
