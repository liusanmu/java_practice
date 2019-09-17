package com.atguigu.nio;/**
 * @author: lsm
 * @description:
 * @create: 2019-09-02 9:10
 */

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Instant;

/**
 @author: ls
 @description:
 @create: 2019-09-02 9:10
 */
public class TestChannel1 {

    //使用直接缓冲区完成文件的复制(内存映射文件)
    @Test
    public void testCopy1() {
        try {
            Path path  = Paths.get("F:/","/BaiduYunDownload","谷粒商城开发工具.rar");
         //   Path path1 = Paths.get("F:/BaiduYunDownload/谷粒商城开发工具.rar");
          //  Path path2 = Paths.get("F:/"+"BaiduYunDownload/谷粒商城开发工具.rar");
            FileChannel inChannel = FileChannel.open(path, StandardOpenOption.READ);
            FileChannel outChannel = FileChannel.open(Paths.get("F:/BaiduYunDownload/new.rar"), StandardOpenOption.CREATE_NEW, StandardOpenOption.CREATE_NEW, StandardOpenOption.READ);

            MappedByteBuffer inMappedBuf = inChannel.map(FileChannel.MapMode.READ_ONLY,0, inChannel.size());
            MappedByteBuffer outMappedBuf = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());


            //直接对缓冲区进行数据的读写操作
            byte[] dst = new byte[inMappedBuf.limit()];
            inMappedBuf.get(dst);
            outMappedBuf.put(dst);

            inChannel.close();
            outChannel.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    /**
     * 利用通道（非直接缓冲区）
     */
    @Test
    public void testCopy() {
        long start = Instant.now().toEpochMilli();
        FileInputStream fis = null;
        FileOutputStream fos = null;
        FileChannel inChannel =  null;
        FileChannel outChannel = null;
        try {
            //获取通道FileChannel
            fis = new FileInputStream("F:/BaiduYunDownload/old.rar");
            fos = new FileOutputStream("F:/BaiduYunDownload/new.rar");
            inChannel = fis.getChannel();
            outChannel = fos.getChannel();

            ////②分配指定大小的缓冲区
            ByteBuffer buf = ByteBuffer.allocate(1024);
             // 将通道中的数据存入缓冲区中
            while (inChannel.read(buf) != -1){
                 buf.flip(); //切换读取数据的模式
                // 将缓冲区中的数据写入通道中
                outChannel.write(buf);
                buf.clear(); //清空缓冲区
            }


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(outChannel != null){
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(inChannel != null){
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        long end = Instant.now().toEpochMilli();
        System.out.println(end-start);
    }

}
