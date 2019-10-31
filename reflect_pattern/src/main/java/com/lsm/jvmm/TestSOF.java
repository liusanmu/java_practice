package com.lsm.jvmm;

import org.junit.Test;

/**
 * @author: lsm
 * @description:
 * @create: 2019-10-09 18:07
 */
public class TestSOF {


    public static void Foo(){
        Foo();
    }
    @Test
    public void test1() {
        Foo();
    }

    public static void method(){
        for(;;)
            method();
    }
    @Test
    public void test2() {
        method();

    }

    @Test
    public void test3() {


    }


}
