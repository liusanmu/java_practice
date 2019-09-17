package com.atguigu.nio;

import org.junit.Test;

import java.nio.ByteBuffer;

/*
 * 一、缓冲区（Buffer）：在 Java NIO 中负责数据的存取。缓冲区就是数组。用于存储不同数据类型的数据
 * 
 * 根据数据类型不同（boolean 除外），提供了相应类型的缓冲区：
 * ByteBuffer
 * CharBuffer
 * ShortBuffer
 * IntBuffer
 * LongBuffer
 * FloatBuffer
 * DoubleBuffer
 * 
 * 上述缓冲区的管理方式几乎一致，通过 allocate() 获取缓冲区
 * 
 * 二、缓冲区存取数据的两个核心方法：
 * put() : 存入数据到缓冲区中
 * get() : 获取缓冲区中的数据
 * 
 * 三、缓冲区中的四个核心属性：
 * capacity : 容量，表示缓冲区中最大存储数据的容量。一旦声明不能改变。
 * limit : 界限，表示缓冲区中可以操作数据的大小。（limit 后数据不能进行读写）
 * position : 位置，表示缓冲区中正在操作数据的位置。
 * 
 * mark : 标记，表示记录当前 position 的位置。可以通过 reset() 恢复到 mark 的位置
 * 
 * 0 <= mark <= position <= limit <= capacity
 * 
 * 四、直接缓冲区与非直接缓冲区：
 * 非直接缓冲区：通过 allocate() 方法分配缓冲区，将缓冲区建立在 JVM 的内存中
 * 直接缓冲区：通过 allocateDirect() 方法分配直接缓冲区，将缓冲区建立在物理内存中。可以提高效率
 */
public class TestBuffer {
	
	@Test
	public void test3(){
		//分配直接缓冲区
		ByteBuffer buf = ByteBuffer.allocateDirect(1024);
		
		System.out.println(buf.isDirect());
	}
	@Test
	public void testOther() {
		String str = "abcde";
		ByteBuffer buf = ByteBuffer.allocate(1024);

		//1.向缓冲区放入字节
		buf.put(str.getBytes());
		System.out.println(buf.position());//5
		/**
		 * 缓冲区的界限(limit)设置为当前位置，并将当前位置(position)重置为0
		 * 源码：
		 * public final Buffer flip() {
		 *         limit = position;
		 *         position = 0;
		 *         mark = -1;
		 *         return this;
		 *     }
		 */
		//2.切换读取数据模式
		buf.flip();
		System.out.println("position:"+buf.position() +"   limit:"+buf.limit() +"   capacity:"+buf.capacity());
		// position:0   limit:5   capacity:1024

		//3.读取字节1
		byte[] dst = new byte[buf.limit()];
		// 批量读取多个字节到 dst 中
		/**
		 * 源码：
		 *   public ByteBuffer get(byte[] dst) {
		 *         return get(dst, 0, dst.length);
		 *     }
		 */
		buf.get(dst);
		System.out.println(new String(dst)); //abcde
		System.out.println("position:"+buf.position() +"   limit:"+buf.limit() +"   capacity:"+buf.capacity());
		// position:5   limit:5   capacity:1024
		buf.flip();
		System.out.println("position:"+buf.position() +"   limit:"+buf.limit() +"   capacity:"+buf.capacity());
		// position:0   limit:5   capacity:1024
		////3.读取字节2
		byte[] dst1 = new byte[buf.limit()];
		//第二个参数知识放入dst1的起始位置,第三个位置为放进dst1的长度
		buf.get(dst1,0, 2);
		System.out.println(new String(dst1)); //ab口口口 说明只有前2位有数据
		System.out.println(new String(dst1,0,2)); //ab(去掉口口口)

		System.out.println("position:"+buf.position() +"   limit:"+buf.limit() +"   capacity:"+buf.capacity());
		//position:2   limit:5   capacity:1024

		//mark() : 标记
		buf.mark();
		//buf.get()不加参数代表从position后只取出一个字节
		System.out.println((char) buf.get()); // c

		System.out.println("position:"+buf.position() +"   limit:"+buf.limit() +"   capacity:"+buf.capacity());
		// position:3   limit:5   capacity:1024

		byte[] dst2 = new byte[buf.limit()];
		buf.get(dst2,1, 2);
		System.out.println(new String(dst2)); //口de口口

		//如果上面的代码改为 buf.get(dst2, 0, 3);就会抛出java.nio.BufferUnderflowException的异常
		// ，因为当前的position已经为3了，如果往后取出大于3个字节便会超过Limit

		//reset() : 恢复到 mark 的位置
		buf.reset();
		System.out.println(buf.position());//2

		//判断缓冲区中是否还有剩余数据
		if(buf.hasRemaining()){

			//获取缓冲区中可以操作的数量
			System.out.println(buf.remaining());//3
		}

	}


	@Test
	public void test2(){
		String str = "abcde";

		ByteBuffer buf = ByteBuffer.allocate(1024);

		buf.put(str.getBytes());

		buf.flip();

		byte[] dst = new byte[buf.limit()];
		buf.get(dst, 0, 2);
		System.out.println(new String(dst, 0, 2)); //ab
		System.out.println(buf.position()); //2

		//mark() : 标记
		buf.mark();

		buf.get(dst, 2, 2);
		System.out.println(new String(dst, 2, 2));//cd
		System.out.println(buf.position());//4

		//reset() : 恢复到 mark 的位置
		buf.reset();
		System.out.println(buf.position());//2

		//判断缓冲区中是否还有剩余数据
		if(buf.hasRemaining()){

			//获取缓冲区中可以操作的数量
			System.out.println(buf.remaining());//3
		}
	}
	
	@Test
	public void test1(){
		String str = "abcde";
		
		//1. 分配一个指定大小的缓冲区
		ByteBuffer buf = ByteBuffer.allocate(1024);
		
		System.out.println("-----------------allocate()----------------");
		System.out.println(buf.position());
		System.out.println(buf.limit());
		System.out.println(buf.capacity());
		
		//2. 利用 put() 存入数据到缓冲区中
		buf.put(str.getBytes());
		
		System.out.println("-----------------put()----------------");
		System.out.println(buf.position());
		System.out.println(buf.limit());
		System.out.println(buf.capacity());
		
		//3. 切换读取数据模式(将缓冲区的界限(limit)设置为当前位置，并将当前位置(position)重置为0)
		buf.flip();
		
		System.out.println("-----------------flip()----------------");
		System.out.println(buf.position());
		System.out.println(buf.limit());
		System.out.println(buf.capacity());
		
		//4. 利用 get() 读取缓冲区中的数据
		byte[] dst = new byte[buf.limit()];
		buf.get(dst);
		System.out.println(new String(dst, 0, dst.length));
		
		System.out.println("-----------------get()----------------");
		System.out.println(buf.position());
		System.out.println(buf.limit());
		System.out.println(buf.capacity());
		
		//5. rewind() : 可重复读
		buf.rewind();
		
		System.out.println("-----------------rewind()----------------");
		System.out.println(buf.position());
		System.out.println(buf.limit());
		System.out.println(buf.capacity());
		
		//6. clear() : 清空缓冲区. 但是缓冲区中的数据依然存在，但是处于“被遗忘”状态
		buf.clear();
		
		System.out.println("-----------------clear()----------------");
		System.out.println(buf.position());
		System.out.println(buf.limit());
		System.out.println(buf.capacity());
		
		System.out.println((char)buf.get());
		
	}

}
