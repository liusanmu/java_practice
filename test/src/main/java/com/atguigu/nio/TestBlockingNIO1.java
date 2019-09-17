package com.atguigu.nio;/**
 * @author: lsm
 * @description:
 * @create: 2019-09-02 19:15
 */

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 @author: ls
 @description:
 @create: 2019-09-02 19:15
 */
public class TestBlockingNIO1 {

    @Test
    public void testServer() throws IOException {
        //获取ServerSocketChannel
        ServerSocketChannel ssChannel = ServerSocketChannel.open();


        //获取FileChannel
        //Paths.get()获取的当前项目下的文件，不是src classpath
        FileChannel outChannel = FileChannel.open(Paths.get("2.jpg"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        // 绑定连接
        ssChannel.bind(new InetSocketAddress(9898));
        // 获取客户端连接的通道
        SocketChannel sChannel = ssChannel.accept();
        //sChannel.read(dst)
        // 分配指定大小的缓冲区
        ByteBuffer dst = ByteBuffer.allocate(1024);

        // 接受客户端的数据保存到本地
        while (sChannel.read(dst) != -1){
            dst.flip();
            outChannel.write(dst);
            dst.clear();
        }
        // 关闭通道，先打开，后关闭
        sChannel.close();
        outChannel.close();
        ssChannel.close();

    }

    @Test
    public void testClient() throws IOException {
        // 获取通道
        SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
        //Paths.get()获取的当前项目下的文件，不是src classpath
        FileChannel inChannel = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);
        ByteBuffer buf = ByteBuffer.allocate(1024);
        // 读取本地文件，并发送到服务端
        while (inChannel.read(buf) != -1){
            buf.flip();
            //网络传输
            sChannel.write(buf);
            buf.clear();
        }
        //关闭通道，先打开，后关闭
        inChannel.close();
        sChannel.close();

    }

}
