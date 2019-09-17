package com.lsm.reflect;/**
 * @author: lsm
 * @description:
 * @create: 2019-09-16 9:14
 */

import org.junit.Test;

import java.lang.reflect.Field;

/**
 @author: ls
 @description: 获取字段属性
 @create: 2019-09-16 9:14
 */
public class RGetField {

 /*   getField(String name)	            获得某个公有的属性对象
      getFields()	                    获得所有公有的属性对象
      getDeclaredField(String name)	    获得某个属性对象
      getDeclaredFields()	            获得所有属性对象

     equals(Object obj)	                属性与obj相等则返回true
     get(Object obj)	                获得obj中对应的属性值
     set(Object obj, Object value)	    设置obj中对应属性值

    */

    @Test
    public void test1() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {

        Class<?> clazz = Class.forName("com.lsm.reflect.User");
        Field name = clazz.getField("name");
        //Field age = clazz.getField("age");//java.lang.NoSuchFieldException: age
       // Field tel = clazz.getField("tel");
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println("1，public修饰的成员变量--->" + field);
        }

        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("2,所有修饰的成员变量： " + declaredField);
        }
        User user = new User(10D);
        // 4，获取指定成员变量
        Field salary = clazz.getDeclaredField("salary");

        // 获取访问权限，暴力反射
        salary.setAccessible(true);


        salary.set(user,1000D);
        System.out.println("4，暴力反射--->" + salary.get(user));



    }
}
