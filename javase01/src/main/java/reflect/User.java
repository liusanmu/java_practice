package reflect;/**
 * @author: lsm
 * @description:
 * @create: 2019-09-16 9:03
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 @author: ls
 @description: @NoArgsConstructor ：
                              生成一个无参数的构造方法，这个annotation在与其他的annotation配合起来使用的时候更加能凸显出他的重要性，
                        例如在使用hibernate这种框架的时候，如果有一个有参数的构造方法的时候，NoArgsConstructor会展示出他的作用。
 @RequiredArgsConstructor： 会生成一个包含常量，和标识了NotNull的变量 的构造方法。生成的构造方法是private，
                 如何想要对外提供使用可以使用staticName选项生成一个static方法。
 @AllArgsContructor： 会生成一个包含所有变量，同时如果变量使用了NotNull annotation ， 会进行是否为空的校验，

 @create: 2019-09-16 9:03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    public String name;
    Integer age;
    protected String tel;
    private Double salary;



    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    private User(String name) {
        this.name = name;
    }

    public User(Double salary) {
        this.salary = salary;
    }

    public void run() {
        System.out.println("跑步...");
    }

    private void eat(String username) {
        System.out.println(username + "正在吃饭...");
    }
}