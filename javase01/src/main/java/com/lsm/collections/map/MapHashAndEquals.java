package com.lsm.collections.map;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author: lsm
 * @description:
 * @create: 2020-02-20 23:47
 */
public class MapHashAndEquals {


    public static void main(String[] args) {
        HashMap<Student, Integer> map = new HashMap<>();
        map.put(new Student("zs", 22), 66);
        map.put(new Student("ls", 23), 67);

        Integer sss = map.get(new Student("ls", 33));
        System.out.println(sss);

    }

    public static class Student {
        String name;
        Integer age;

        public Student(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
        @Override
        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            Student student = (Student) o;
//            return Objects.equals(name, student.name) &&
//                    Objects.equals(age, student.age);
            if (o instanceof Student) {
                Student student = (Student) o;
                return name.equals(student.name)  && age.equals(student.age);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }
    }

    private class B {}
}
// 只有卸载外面才会另外编译成一个class文件
class A {

}