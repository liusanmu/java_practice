package reflect; /**
 * @author: lsm
 * @description:
 * @create: 2019-09-16 9:01
 */

/**
 @author: ls
 @description: 得到反射对象
 @create: 2019-09-16 9:01
 */
public class RGetClass {

    public static void main(String[] args) throws ClassNotFoundException {

        //Class.forName()
        Class aClass = Class.forName("com.lsm.reflect.User");
        System.out.println("aClass = " + aClass);

        //Obj.class;
        Class<User> bClass = User.class;
        System.out.println("bClass = " + bClass);

        User u = new User();
        Class  cClass = u.getClass();
        System.out.println("cClass = " + cClass);

        System.out.println(aClass == bClass);
        System.out.println(bClass == cClass);


    }


}

//
//1.2，动静态编译
//
//        静态编译：在编译期就确定类或者方法的属性，有点一次到位的意思。
//
//        动态编译：在运行期确定类或者方法的属性，好比什么时候用就什么时候编译。
//
//        但是这两种编译方式有什么区别，先说静态编译吧。我想大家都遇到过项目需求频繁变更的情况，可能是更改需求，可能是添加新的需求。对于静态编译，因为这是一次性编译，对于确定的代码是不能更改的，除非下线，更改，测试，再重新上线，显然这是不妥的。
//
//        因此就需要动态编译，即在程序运行期间也可以进行相应的操作，一切操作方式都是灵活的，所以说反射对于程序是多么重要。
//
//        1.3，优缺点
//
//        先来说说反射的优点：
//
//        1，可以在程序运行的过程中，操作这些对象。
//        2，可以解耦，提高程序的可扩展性。
//
//        缺点：
//
//        1，因为是JVM操作，所以对于性能来说会有所下降。
//
//        2，容易对程序源码造成一定的混乱。