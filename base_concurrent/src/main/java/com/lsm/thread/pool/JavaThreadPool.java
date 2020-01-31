package com.lsm.thread.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**  
 * @Description: JavaThreadPool.java
 * @author: liusen
 * @date:   2019年4月19日 下午3:32:19   
 */
public class JavaThreadPool {
	
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add("STR_"+i);
		}
		int threadNum = list.size() < 5 ? list.size() : 5;
	/*	ThreadPoolExecutor(int corePoolSize, 
		int maximumPoolSize,
		long keepAliveTime,
		TimeUnit unit,
		BlockingQueue<Runnable> workQueue
		RejectedExecutionHandler handler)

		corePoolSize: 线程池维护线程的最少线程数,也是核心线程数,包括空闲线程
		maximumPoolSize: 线程池维护线程的最大线程数
		keepAliveTime: 线程池维护线程所允许的空闲时间
		unit: 程池维护线程所允许的空闲时间的单位
		workQueue: 线程池所使用的缓冲队列
		
		/*当一个任务通过execute(Runnable)方法欲添加到线程池时：
		1、 如果此时线程池中的数量小于corePoolSize，即使线程池中的线程都处于空闲状态，也要创建新的线程来处理被添加的任务。
		2、 如果此时线程池中的数量等于 corePoolSize，但是缓冲队列 workQueue未满，那么任务被放入缓冲队列。
		3、如果此时线程池中的数量大于corePoolSize，缓冲队列workQueue满，并且线程池中的数量小于maximumPoolSize，建新的线程来处理被添加的任务。
		4、 如果此时线程池中的数量大于corePoolSize，缓冲队列workQueue满，并且线程池中的数量等于maximumPoolSize，那么通过 handler所指定的策略来处理此任务。也就是：处理任务的优先级为：核心线程corePoolSize、任务队列workQueue、最大线程 maximumPoolSize，如果三者都满了，使用handler处理被拒绝的任务。
		5、 当线程池中的线程数量大于 corePoolSize时，如果某线程空闲时间超过keepAliveTime，线程将被终止。这样，线程池可以动态的调整池中的线程数。*/
		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, threadNum, 300, TimeUnit.MILLISECONDS,
					new ArrayBlockingQueue<Runnable>(3),new ThreadPoolExecutor.CallerRunsPolicy());
	
		for (int i = 0; i < threadNum; i++) {
			 executor.execute(new PrintStringThread(i,list,threadNum));
		}
		  executor.shutdown();
	}

}

class PrintStringThread implements Runnable {
	private int num;
	private List<String> list;
	private int threadNum;

	public PrintStringThread(int num, List<String> strList, int threadNum) {
		this.num = num;
		this.list = strList;
		this.threadNum = threadNum;
	}

	@Override
	public void run() {
		int length = 0;
		for (String str : list) {
			if (length % threadNum == num) {
				System.out.println("线程编号：" + num + "，字符串：" + str);
			}
			length++;
		}

	}

}
/*
<bean id="poolTaskExecutor"      class="org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor">
<!-- 核心线程数，默认为1 -->
<property name="corePoolSize" value="5" />
<!-- 最大线程数，默认为Integer.MAX_VALUE -->
<property name="maxPoolSize" value="50" />
<!-- 队列最大长度，一般需要设置值>=notifyScheduledMainExecutor.maxNum；默认为Integer.MAX_VALUE -->
<property name="queueCapacity" value="2000" />
<!-- 线程池维护线程所允许的空闲时间，默认为60s -->
<property name="keepAliveSeconds" value="100" />
<!-- 线程池对拒绝任务（无线程可用）的处理策略，目前只支持AbortPolicy、CallerRunsPolicy；默认为后者 -->
<property name="rejectedExecutionHandler">
    <!-- AbortPolicy:直接抛出java.util.concurrent.RejectedExecutionException异常 -->
    <!-- CallerRunsPolicy:主线程直接执行该任务，执行完之后尝试添加下一个任务到线程池中，可以有效降低向线程池内添加任务的速度 -->
    <!-- DiscardOldestPolicy:抛弃旧的任务、暂不支持；会导致被丢弃的任务无法再次被执行 -->
    <!-- DiscardPolicy:抛弃当前任务、暂不支持；会导致被丢弃的任务无法再次被执行 -->
    <bean class="java.util.concurrent.ThreadPoolExecutor$CallerRunsPolicy" />
</property>
</bean>
*/