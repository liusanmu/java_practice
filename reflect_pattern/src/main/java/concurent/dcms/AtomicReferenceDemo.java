package concurent.dcms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author: ls
 * @description: 原子引用
 * @create: 2019-10-31 18:43
 */
public class AtomicReferenceDemo {

    public static void main(String[] args) {
        User z3 = new User("z3", 20);
        User l4 = new User("l4", 21);
        AtomicReference<User> atomicReference = new AtomicReference<>();
        atomicReference.set(z3);
       //
        System.out.println("atomicReference.compareAndSet(z3, l4) = " + atomicReference.compareAndSet(z3, l4)+"==="+atomicReference.get());
        System.out.println("atomicReference.compareAndSet(z3, l4) = " + atomicReference.compareAndSet(z3, l4)+"==="+atomicReference.get());
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
class User{

    private String userName;
    private Integer age;
}