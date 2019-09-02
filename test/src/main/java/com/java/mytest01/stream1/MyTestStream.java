package com.java.mytest01.stream1;

import com.atguigu.java8.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

/**
 * @author: ls
 * @description:
 * @create: 2019-08-12 14:30
 */
public class MyTestStream {
    List<Employee> emps = Arrays.asList(
            new Employee(102, "李四", 59, 6666.66),
            new Employee(101, "张三", 18, 9999.99),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );

    @Test
    public void test() {
      emps.stream().filter(employee -> employee.getSalary() > 7000)
                .sorted(comparing(Employee::getSalary))
                .map(Employee::getName).distinct()
                .forEach(System.out::println);


        List<String> collect = emps.stream().filter(employee -> employee.getSalary() > 7000)
                .sorted(comparing(Employee::getSalary))
                .map(Employee::getName).distinct()
                .collect(toList());
        System.out.println(collect);


    }
}
