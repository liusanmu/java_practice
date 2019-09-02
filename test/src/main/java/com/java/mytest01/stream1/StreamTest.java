package com.java.mytest01.stream1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author: ls
 * @description:
 * @create: 2019-08-12 15:02
 */
public class StreamTest {
   static List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 800, Dish.Type.MEAT),
            new Dish("beef", false, 700, Dish.Type.MEAT),
            new Dish("chicken", false, 400, Dish.Type.MEAT),
            new Dish("french fries", true, 530, Dish.Type.OTHER),
            new Dish("rice", true, 350, Dish.Type.OTHER),
            new Dish("season fruit", true, 120, Dish.Type.OTHER),
            new Dish("pizza", true, 550, Dish.Type.OTHER),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH),
            new Dish("prawns", false, 300, Dish.Type.FISH),
            new Dish("salmon", false, 450, Dish.Type.FISH));

    // 筛选出所有素菜
    @Test
    public void test1() {
        List<Dish> vegetarianDishes = new ArrayList<>();
        for(Dish d: menu){
            if(d.isVegetarian()){
                vegetarianDishes.add(d);
            }
        }
        for (Dish vegetarianDish : vegetarianDishes) {
            System.out.println(vegetarianDish);
        }
        System.out.println("------------lambda版-------------");
        menu.stream().filter(menu -> menu.isVegetarian())
                     .collect(toList())
                     .forEach(System.out::println);
        System.out.println("--------------方法引用版-----------");
        menu.stream().filter(Dish::isVegetarian)
                .collect(toList())
                .forEach(System.out::println);

    }

//	对象::实例方法
//	类::静态方法
//	类::实例方法

    //筛选和切片
    @Test
    public void test2() {

        menu.stream().distinct().forEach(System.out::println);

        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);

    }
    //请注意 limit 也可以用在无序流上，比如源是一个 Set 。这种情况下， limit 的结果不会以
    //任何顺序排列。
    @Test
    public void test3() {
        menu.stream()
                .filter(d -> d.getCalories() > 300)
                .limit(3).forEach(System.out::println);
               // .collect(toList());
        //你将如何利用流来筛选前两个荤菜呢
        menu.stream().filter(dish -> dish.getType() == Dish.Type.MEAT).limit(2).forEach(System.out::println);
    }


    @Test
    public void test() {
        //映射
        List<String> dishNames = menu.stream()
                .map(Dish::getName)
                .collect(toList());//返回String类型
        System.out.println("dishNames = " + dishNames);

        List<String> words = Arrays.asList("JavaJ 8", "Lambdas", "In", "Action");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(toList());
        System.out.println("words = " + words);
        System.out.println("wordLengths = " + wordLengths);

       // words.stream().map(word -> word.split("")).distinct().forEach(e -> System.out.println(Arrays.toString(e)));

        List<String[]> collect = words.stream().map(word -> word.split("")).distinct().collect(toList());
    }

    @Test
    public void test4() {
        List<String> words =  Arrays.asList("Hello","World");
        words.stream().map(word -> word.split("")).distinct().forEach(e -> System.out.println(Arrays.toString(e)));
        // String words = "Hello,World";
      //  Stream<String> words = Stream.of("Hello,World");
     //   words.map(word -> word.split("")).distinct().forEach(e -> System.out.println(Arrays.toString(e)));
        /*List<String[]> collect = words.map(word -> word.split("")).distinct().collect(toList());
        for (String[] strings : collect) {
            System.out.println(strings);
        }*/
        String[] arrayOfWords = {"Goodbye", "World"};
        Stream<String> streamOfwords = Arrays.stream(arrayOfWords);

       // streamOfwords.str
    }

    @Test
    public void test5() {
        String[] arrayOfWords = {"Goodbye", "World"};
        Stream<String> streamOfwords = Arrays.stream(arrayOfWords);
        /*streamOfwords
                .map(word -> word.split(""))
                .map(Arrays::stream)
                .distinct()
                .collect(toList());*/

        List<String> uniqueCharacters =
                streamOfwords
                        .map(w -> w.split(""))
                        .flatMap(Arrays::stream)
                        .distinct()
                        .collect(Collectors.toList());
    }


    //创建流
    @Test
    public void test6() {
        // 静态方法 Stream.of ，通过显式值创建一个流。它可以接受任意数量的参数
        Stream<String> stream = Stream.of("Java 8 ", "Lambdas ", "In ", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);

        // 空流
        Stream<String> emptyStream = Stream.empty();

        //由数组创建流
        int[] numbers = {2, 3, 5, 7, 11, 13};
        int sum = Arrays.stream(numbers).sum();

        //
       // Stream.
    }


    // 匹配
    @Test
    public void test7() {
        boolean b = menu.stream().allMatch(d -> d.getCalories() > 300);
        System.out.println(b);

        boolean b1 = menu.stream().anyMatch(d -> d.getCalories() > 300);
        System.out.println(b1);

        boolean b2 = menu.stream().noneMatch(d -> d.getCalories() > 300);
        System.out.println(b2);

        //查找元素
         menu.stream().filter(d -> d.getCalories() > 300).findFirst().ifPresent(System.out::println);

        //findAny 方法将返回当前流中的任意元素
         menu.stream().filter(d -> d.getCalories() > 300).findAny().ifPresent(System.out::println);

        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);

                someNumbers.stream()
                        .map(x -> x * x)
                        .filter(x -> x % 3 == 0)
                        .findFirst().ifPresent(System.out::println);; // 9

    }


    //规约，reduce

    /**
     * int sum = numbers
     *
     *
     *
     * .stream().reduce(0, (a, b) -> a + b);
     * reduce 接受两个参数：
     *   一个初始值，这里是0；
     *   一个 BinaryOperator<T> 来将两个元素结合起来产生一个新值，这里我们用的是
     * lambda (a, b) -> a + b 。
     */
    @Test
    public void test8() {

        List<Integer> numbers = Arrays.asList(5, 6);
        int sum = numbers.stream().reduce(2,(a, b) -> a + b);
        System.out.println("sum = " + sum);
        // 方法引用求和
        int sum1 = numbers.stream().reduce(0, Integer::sum);
        System.out.println("sum1 = " + sum1);
        //不用没有初始值
        numbers.stream().reduce((a, b) -> (a + b)).ifPresent(System.out::println);

        // 求最大值
        numbers.stream().reduce(Integer::max).ifPresent(System.out::println);
        // 求最小值
        numbers.stream().reduce(Integer::min).ifPresent(System.out::println);
        numbers.stream().reduce((x, y) -> x < y ? x : y).ifPresent(System.out::println);




    }


}
