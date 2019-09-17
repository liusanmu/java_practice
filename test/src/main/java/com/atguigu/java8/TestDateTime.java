package com.atguigu.java8;/**
 * @author: lsm
 * @description:
 * @create: 2019-09-03 8:49
 */

import org.junit.Test;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

/**
 @author: ls
 @description:
 @create: 2019-09-03 8:49
 */
public class TestDateTime {

    @Test
    public void test() {

        System.out.println(LocalDateTime.now());
        // 到秒
        long a = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
        System.out.println("a = " + a);

        long d = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        System.out.println("d = " + d);

        //到毫秒
        long b = System.currentTimeMillis();
        System.out.println("b = " + b);

        long c = Instant.now().toEpochMilli();
        System.out.println("c = " + c);

        long time = Timestamp.valueOf(LocalDateTime.now()).getTime();
        System.out.println("time = " + time);


        LocalDate.now().toEpochDay();

    }
}
