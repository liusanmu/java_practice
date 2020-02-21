package com.lsm.collections.map.myhm;

/**
 * @author: lsm
 * @description: 面向接口编程思想
 * 双列集合接口
 * @create: 2020-02-21 0:35
 */
public interface MyMap<K, V> {

    V put(K k, V v);

    V get(K k);

    //内部接口
    interface Entry<K, V>{
        K getKey();
        V getValue();
    }
}
