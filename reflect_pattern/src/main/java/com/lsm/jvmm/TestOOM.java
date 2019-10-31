package com.lsm.jvmm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 java.lang.OutOfMemoryError: Java heap space
 ------>java堆内存溢出，此种情况最常见，一般由于内存泄露或者堆的大小设置不当引起。对于内存泄露，需要通过内存监控软件查找程序中的泄露代码，
        而堆大小可以通过虚拟机参数-Xms,-Xmx等修改。
 java.lang.OutOfMemoryError: PermGen space
 ------>java永久代溢出，即方法区溢出了，一般出现于大量Class或者jsp页面，或者采用cglib等反射机制的情况，因为上述情况会产生大量的Class信息存储于方法区。
            此种情况可以通过更改方法区的大小来解决，使用类似-XX:PermSize=64m -XX:MaxPermSize=256m的形式修改。另外，过多的常量尤其是字符串也会导致方法区溢出。
 java.lang.StackOverflowError
 ------> 不会抛OOM error，但也是比较常见的Java内存溢出。JAVA虚拟机栈溢出，一般是由于程序中存在死循环或者深度递归调用造成的，栈大小设置太小也会出现此种溢出。
            可以通过虚拟机参数-Xss来设置栈的大小。
 */
public class TestOOM {

    @Test
    public void test() {
        List list=new ArrayList();
        for(;;){
            int[] tmp=new int[1000000];
            list.add(tmp);
        }
    }



 

}
