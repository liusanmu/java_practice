package com.lsm.collections.map.myhm;

import org.junit.Test;

/**
 * @author: lsm
 * @description:
 * @create: 2020-02-21 19:46
 */
public class TestMyMap {
    
    @Test
    public void test()throws Exception{
        MyHashMap<String,String> map = new MyHashMap<>();
        for (int i = 0; i < 1000; i++) {
            map.put("key"+i, "val"+i);
        }

        for (int i = 0; i < 1000; i++) {
            String s = map.get("key" + i);
            System.out.println(s);
        }

    }
}
