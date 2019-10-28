package com.lsm.jvmm;

import org.junit.Test;

import java.util.Random;

/**
 * @author: lsm
 * @description:
 * @create: 2019-10-07 13:59
 *
 *  -Xms1024m -Xmx1024m -XX:+PrintGCDetails
 */
public class TestJVM {

    @Test
    public void testOptions()throws Exception{
        long maxMemory = Runtime.getRuntime().maxMemory() ;//返回 Java 虚拟机试图使用的最大内存量。
        long totalMemory = Runtime.getRuntime().totalMemory() ;//返回 Java 虚拟机中的内存总量。
        System.out.println("MAX_MEMORY(XMX) = " + maxMemory + "（字节）、" + (maxMemory / (double)1024 / 1024) + "MB");
        System.out.println("TOTAL_MEMORY (XMS)= " + totalMemory + "（字节）、" + (totalMemory / (double)1024 / 1024) + "MB");

    }
    @Test
    public void testOOM()throws Exception{
       /* String str = "TOTAL_MEMORYTOTAL_MEMORYTOTAL_MEMORYTOTAL_MEMORY";
        while (true){
            str += str + new Random().nextInt(999999999) + new Random().nextInt(999999999);
        }*/

        byte[] bytes = new byte[40 * 1024 *1024];

    }
}

