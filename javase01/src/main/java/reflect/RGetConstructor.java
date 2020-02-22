package reflect;/**
 * @author: lsm
 * @description:
 * @create: 2019-09-16 11:09
 */

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 @author: ls
 @description:
 getConstructor(Class...<?> parameterTypes)	获得该类中与参数类型匹配的公有构造方法
 getConstructors()	获得该类的所有公有构造方法
 getDeclaredConstructor(Class...<?> parameterTypes)	获得该类中与参数类型匹配的构造方法
 getDeclaredConstructors()	获得该类所有构造方法

 newInstance(Object... initargs)	根据传递的参数创建类的对象
 @create: 2019-09-16 11:09
 */
public class RGetConstructor {

    @Test
    public void test1() throws NoSuchMethodException {

        Class<User> clazz = User.class;
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("getConstructors::::" + constructor);

        }
        //获取全部构造函数
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("getDeclaredConstructors:" + declaredConstructor);

        }
        // 获取部分构造函数
        Constructor<User> constructor = clazz.getConstructor(String.class, Integer.class);
        System.out.println("部分构造：" + constructor);

    }

    @Test
    public void test2() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = Class.forName("com.lsm.reflect.User");
        Constructor<User> constructor = clazz.getConstructor(String.class, Integer.class);

        User user = constructor.newInstance("张飞", 18);
        System.out.println("user = " + user);


        Constructor nameConstructor = clazz.getDeclaredConstructor(String.class);
        nameConstructor.setAccessible(true);
        Object instance = nameConstructor.newInstance("刘备");
        System.out.println(instance);


    }
}
