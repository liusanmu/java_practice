package com.java.pattern.strategy.order;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author: lsm
 * @description: Bean工具类
 *         非Sprign管理的类中获取spring的bean
 * @create: 2019-09-29 0:27
 */

@Component
public class BeanTool implements ApplicationContextAware {

    private static ApplicationContext applicationContext;


    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        if (applicationContext == null) {
            applicationContext = context;
        }
    }

    public  static  Object getBean(String name){
        return applicationContext.getBean(name);
    }
    //T是个修饰符的功能，表示是个泛型方法，就像有static修饰的方法是个静态方法一样。
    //<T> 不是返回值，表示传入参数有泛型
    //所以前面的<T> T中的<T>代表的是 返回值T的类型，也就是入参为class的时候，返回值类型的呃前面需要加一个<T> 来限定
    // 后面泛型T的类型，告诉后面返回值T的类型是什么，返回值为void，也不能不写<T>，因为需要和入参的类型保持一致。
    public static <T> T getBean(Class<T> clazz){
        return applicationContext.getBean(clazz);
    }
}
