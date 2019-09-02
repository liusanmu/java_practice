package com.atguigu.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
 * 一、 Stream 的操作步骤
 * 
 * 1. 创建 Stream
 * 
 * 2. 中间操作
 *
 *
 筛选和切片
filter(Predicate p)	接收 Lambda ， 从流中排除某些元素。
distinct()	筛选，通过流所生成元素的 hashCode() 和 equals() 去
	除重复元素
limit(long maxSize)	截断流，使其元素不超过给定数量。
skip(long n)	跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素
	不足 n 个，则返回一个空流。与 limit(n) 互补


映射
map(Function f)	接收一个函数作为参数，该函数会被应用到每个元
	素上，并将其映射成一个新的元素。
mapToDouble(ToDoubleFunction f)	接收一个函数作为参数，该函数会被应用到每个元
	素上，产生一个新的 DoubleStream。
mapToInt(ToIntFunction f)	接收一个函数作为参数，该函数会被应用到每个元
	素上，产生一个新的 IntStream。
mapToLong(ToLongFunction f)	接收一个函数作为参数，该函数会被应用到每个元
	素上，产生一个新的 LongStream。
flatMap(Function f)	接收一个函数作为参数，将流中的每个值都换成另
	一个流，然后把所有流连接成一个流

排序
sorted()	产生一个新流，其中按自然顺序排序
sorted(Comparator comp)	产生一个新流，其中按比较器顺序排序
 *
 * 3. 终止操作
 *
 *查找与匹配
allMatch(Predicate p)	检查是否匹配所有元素
anyMatch(Predicate p)	检查是否至少匹配一个元素
noneMatch(Predicate p)	检查是否没有匹配所有元素
findFirst()	返回第一个元素
findAny()	返回当前流中的任意元素
count()	返回流中元素总数
max(Comparator c)	返回流中最大值
min(Comparator c)	返回流中最小值
forEach(Consumer c)	内部迭代(使用 Collection 接口需要用户去做迭
	代，称为外部迭代。相反，Stream API 使用内部
	迭代——它帮你把迭代做了)

归约
	reduce(T iden, BinaryOperator b)	可以将流中元素反复结合起来，得到一个值。
		返回 T
	reduce(BinaryOperator b)	可以将流中元素反复结合起来，得到一个值。
		返回 Optional<T>
收集

collect(Collector c)	将流转换为其他形式。接收一个 Collector接口的
	实现，用于给Stream中元素做汇总的方法

 */
public class TestStreamAPI1 {
	
	List<Employee> emps = Arrays.asList(
			new Employee(102, "李四", 59, 6666.66),
			new Employee(101, "张三", 18, 9999.99),
			new Employee(103, "王五", 28, 3333.33),
			new Employee(104, "赵六", 8, 7777.77),
			new Employee(104, "赵六", 8, 7777.77),
			new Employee(104, "赵六", 8, 7777.77),
			new Employee(105, "田七", 38, 5555.55)
	);

	//2. 中间操作
	/*
		映射
		map——接收 Lambda ， 将元素转换成其他形式或提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
		flatMap——接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
	 */

@Test
	public void test1(){
		Stream<String> str = emps.stream()
			.map((e) -> e.getName());
		str.forEach(System.out::println);
		System.out.println("-------------------------------------------");
		
		List<String> strList = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");

		//emps.stream(). function T get ()

		Stream<String> stream = strList.stream()
			   .map(String::toUpperCase);
		
		stream.forEach(System.out::println);
		
		Stream<Stream<Character>> stream2 = strList.stream()
			   .map(TestStreamAPI1::filterCharacter);
		
		stream2.forEach((sm) -> {
			sm.forEach(System.out::println);
		});
		
		System.out.println("---------------------------------------------");
		
		Stream<Character> stream3 = strList.stream()
			   .flatMap(TestStreamAPI1::filterCharacter);
		
		stream3.forEach(System.out::println);
	}

	public static Stream<Character> filterCharacter(String str){
		List<Character> list = new ArrayList<>();
		
		for (Character ch : str.toCharArray()) {
			list.add(ch);
		}
		
		return list.stream();
	}
	
	/*
		sorted()——自然排序
		sorted(Comparator com)——定制排序
	 */
	@Test
	public void test2(){
		emps.stream()
			.map(Employee::getName)
			.sorted()
			.forEach(System.out::println);
		
		System.out.println("------------------------------------");
		
		emps.stream()
			.sorted((x, y) -> {
				if(x.getAge() == y.getAge()){
					return x.getName().compareTo(y.getName());
				}else{
					return Integer.compare(x.getAge(), y.getAge());
				}
			}).forEach(System.out::println);
	}
}
