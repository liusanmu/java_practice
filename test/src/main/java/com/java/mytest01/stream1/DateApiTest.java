package com.java.mytest01.stream1;/**
 * @author: lsm
 * @description:
 * @create: 2019-08-16 10:18
 */

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoField;

/**
 @author: ls
 @description:
 @create: 2019-08-16 10:18
 */
public class DateApiTest {
    
    @Test
    public void test() {
        LocalDate lDate = LocalDate.of(2019, 1, 10);
        int year = lDate.getYear();
        System.out.println("year = " + year);
        // 月份
        Month month = lDate.getMonth();
        System.out.println(month);
        // 第几个信息
        DayOfWeek dayOfWeek = lDate.getDayOfWeek();
        System.out.println("dayOfWeek = " + dayOfWeek);
        // 日
        int dayOfMonth = lDate.getDayOfMonth();
        System.out.println("dayOfMonth = " + dayOfMonth);
        // 月长度
        int lengthOfMonth = lDate.lengthOfMonth();
        System.out.println("lengthOfMonth = " + lengthOfMonth);
        // 闰年
        boolean leap = lDate.isLeapYear();
        System.out.println("leap = " + leap);


        // 当前时间
        LocalDate today = LocalDate.now();
        System.out.println("today = " + today);

    }

    /**
     * 传递一个 TemporalField 参数给 get 方法拿到同样的信息。 TemporalField 是一个接口，它定
     * 义了如何访问 temporal 对象某个字段的值。 ChronoField 枚举实现了这一接口
     */
    @Test
    public void test2() {

        LocalDate date = LocalDate.of(2019, 1, 10);
        int year = date.get(ChronoField.YEAR);
        System.out.println("year = " + year);
        int month = date.get(ChronoField.MONTH_OF_YEAR);
        System.out.println("month = " + month);
        int day = date.get(ChronoField.DAY_OF_MONTH);
        System.out.println("day = " + day);

    }

    @Test
    public void test3() {
        LocalTime time = LocalTime.of(13, 45, 20);
        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();
    }

    @Test
    public void test4() {

        LocalDate date = LocalDate.parse("2014-03-18");
        System.out.println("date = " + date);
        LocalTime time = LocalTime.parse("13:45:20");
        System.out.println("time = " + time);
    }

    @Test
    public void test5() {

        LocalDate date = LocalDate.of(2019, 1, 10);

        LocalTime time = LocalTime.of(13, 45, 20);
        //法一
        LocalDateTime dt1 = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45, 20);
        //法二
        LocalDateTime dt2 = LocalDateTime.of(date, time);
        //法三
        LocalDateTime dt3 = date.atTime(13, 45, 20);

        LocalDateTime dt4 = date.atTime(time);

        LocalDateTime dt5 = time.atDate(date);

        //获取LocalDate
        LocalDate date1 = dt1.toLocalDate();
        //获取LocalTime
        LocalTime time1 = dt1.toLocalTime();

    }

    /**
     * Instant
     */
    @Test
    public void test6() {

        Instant.ofEpochSecond(3);
        Instant.ofEpochSecond(3, 0);
        Instant.ofEpochSecond(2, 1_000_000_000);
        Instant.ofEpochSecond(4, -1_000_000_000);

        // Duration d1 = Duration.between(time1, time2);
        // Duration d1 = Duration.between(dateTime1, dateTime2);
        // Duration d2 = Duration.between(instant1, instant2);

    }



}
