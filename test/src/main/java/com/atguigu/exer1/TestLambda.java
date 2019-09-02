package com.atguigu.exer1;

import com.atguigu.java8_1.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestLambda {
	
	List<Employee> emps = Arrays.asList(
			new Employee(101, "张三", 18, 9999.99),
			new Employee(102, "李四", 59, 6666.66),
			new Employee(103, "王五", 28, 3333.33),
			new Employee(104, "赵六", 8, 7777.77),
			new Employee(105, "田七", 38, 5555.55)
	);
	
	@Test
	public void test1(){
		Collections.sort(emps, (e1, e2) -> {
			if(e1.getAge() == e2.getAge()){
					return e1.getName().compareTo(e2.getName());
			}else{
				return -Integer.compare(e1.getAge(), e2.getAge());
			}
		});
		
		for (Employee emp : emps) {
			System.out.println(emp);
		}
	}
	
	@Test
	public void test2(){
		String trimStr = strHandler("\t\t\t 我大尚硅谷威武   ", (str) -> str.trim());
		System.out.println(trimStr);
		
		String upper = strHandler("abcdef", (str) -> str.toUpperCase());
		System.out.println(upper);
		
		String newStr = strHandler("我大尚硅谷威武", (str) -> str.substring(2, 5));
		System.out.println(newStr);
	}
	
	//需求：用于处理字符串
	public String strHandler(String str, MyFunction mf){
		return mf.getValue(str);
	}
	
	@Test
	public void test3(){
		op(100L, 200L, (x, y) -> x + y);
		
		op(100L, 200L, (x, y) -> x * y);
	}
	
	//需求：对于两个 Long 型数据进行处理
	public void op(Long l1, Long l2, MyFunction2<Long, Long> mf){
		System.out.println(mf.getValue(l1, l2));
	}
/*	上述 Lambda 表达式中的参数类型都是由编译器推断得出的。Lambda 表达式中无需指定类型，程序依然可以编译，
	这是因为 javac 根据程序的上下文，在后台推断出了参数的类型。
	Lambda 表达式的类型依赖于上下文环境，是由编译器推断出来的。这就是所谓的“类型推断”*/
}
