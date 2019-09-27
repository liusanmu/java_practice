package com.lsm.reflect;/**
 * @author: lsm
 * @description:
 * @create: 2019-09-16 11:58
 */

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: ls
 * @description: getMethod(String name, Class... < ? > parameterTypes)        获得该类某个公有的方法
 * getMethods()	                                        获得该类所有公有的方法
 * getDeclaredMethod(String name, Class...<?>             parameterTypes)	获得该类某个方法
 * getDeclaredMethods()	                                获得该类所有方法
 * @create: 2019-09-16 11:58
 */
public class RGetMethod {

    @Test
    public void test1() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class clazz = Class.forName("com.lsm.reflect.User");
        Method method = clazz.getMethod("run");
        Object obj = clazz.newInstance();
        method.invoke(obj);

        Method method1 = clazz.getDeclaredMethod("eat", String.class);
        //java.lang.IllegalAccessException: Class com.lsm.reflect.RGetMethod can not access a member of class com.lsm.reflect.User with modifiers "private"
        method1.setAccessible(true);
        method1.invoke(obj, "tom");

    }


    /**
     * 反射还可以获取到Object类中的的方法
     *
     * @throws Exception
     */
    @Test
    public void test2() throws Exception {
        Class clazz = Class.forName("com.lsm.reflect.User");
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);

        }

    }

    @Test
    public void test() throws ClassNotFoundException {
        Class clazz = Class.forName("com.lsm.reflect.VipUser");
        Method[] dclaredMethods = clazz.getDeclaredMethods();
        for (Method method : dclaredMethods) {
            System.out.println(method);
        }
        /**
         * public boolean com.lsm.reflect.VipUser.equals(java.lang.Object)
         * public java.lang.String com.lsm.reflect.VipUser.toString()
         * public int com.lsm.reflect.VipUser.hashCode()
         * protected boolean com.lsm.reflect.VipUser.canEqual(java.lang.Object)
         * public void com.lsm.reflect.VipUser.speack()
         * public java.lang.String com.lsm.reflect.VipUser.getLeave()
         * public void com.lsm.reflect.VipUser.setLeave(java.lang.String)
         */
    }

    @Test
    public void test3() throws Exception {
        Class clazz = Class.forName("com.lsm.reflect.VipUser");
       /* Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }

        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);

        }
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }*/
        //可以获取到父类和Object中的方法
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);

        }
        /**
         * public boolean com.lsm.reflect.VipUser.equals(java.lang.Object)
         * public java.lang.String com.lsm.reflect.VipUser.toString()
         * public int com.lsm.reflect.VipUser.hashCode()
         * public java.lang.String com.lsm.reflect.VipUser.getLeave()
         * public void com.lsm.reflect.VipUser.speack()
         * public void com.lsm.reflect.VipUser.setLeave(java.lang.String)
         * public void com.lsm.reflect.User.run()
         * public java.lang.String com.lsm.reflect.User.getName()
         * public void com.lsm.reflect.User.setName(java.lang.String)
         * public void com.lsm.reflect.User.setAge(java.lang.Integer)
         * public void com.lsm.reflect.User.setSalary(java.lang.Double)
         * public java.lang.String com.lsm.reflect.User.getTel()
         * public java.lang.Double com.lsm.reflect.User.getSalary()
         * public java.lang.Integer com.lsm.reflect.User.getAge()
         * public void com.lsm.reflect.User.setTel(java.lang.String)
         * public final void java.lang.Object.wait() throws java.lang.InterruptedException
         * public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException
         * public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException
         * public final native java.lang.Class java.lang.Object.getClass()
         * public final native void java.lang.Object.notify()
         * public final native void java.lang.Object.notifyAll()
         *
         * Process finished with exit code 0
         */

    }
}
