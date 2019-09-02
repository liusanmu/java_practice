package com.java.mytest01.stream1;/**
 * @author: lsm
 * @description:
 * @create: 2019-08-16 15:33
 */

import org.junit.Test;

/**
 @author: ls
 @description:
 @create: 2019-08-16 15:33
 */
public class RefactorTest {

    @Test
    public void test1() {

        Runnable r1 = new Runnable(){
            public void run(){
                System.out.println("Hello");
            }
        };
        Runnable r2 = () -> System.out.println("Hello");

    }

/*
在匿名类中， this 代表的是类自身，但
是在Lambda中，它代表的是包含类。其次，匿名类可以屏蔽包含类的变量，而Lambda表达式不
能（它们会导致编译错误）
 */
  @Test
  public void test2() {
      int a = 10;
      Runnable r1 = () -> {
        //  int a = 2;
          System.out.println(a);
      };

      Runnable r2 = new Runnable(){
          public void run(){
              int a = 2;
              System.out.println(a);
          }
      };
  }

    interface Task{
        public void execute();
    }
    public static void doSomething(Runnable r){ r.run(); }
    public static void doSomething(Task a){ a.execute(); }

    @Test
    public void test3() {
        doSomething(new Task() {
            public void execute() {
                System.out.println("Danger danger!!");
            }
        });

     //   doSomething(() -> System.out.println("Danger danger!!"));//报错Ambiguous method call. Both
        doSomething((Task) () -> System.out.println("aaaaa"));

    }

}
