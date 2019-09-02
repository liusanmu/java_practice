package com.java.mytest01.stream1;

/**
 * @author: ls
 * @description:
 * @create: 2019-08-12 14:59
 */
public class Dish implements Comparable<Dish>{
    private final String name;
    // 素食者
    private final boolean vegetarian;
    // 卡路里
    private final int calories;
    private final Type type;


    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }
    public String getName() {
        return name;
    }
    public boolean isVegetarian() {
        return vegetarian;
    }
    public int getCalories() {
        return calories;
    }
    public Type getType() {
        return type;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + calories;
        //result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        //long temp;
        //temp = Double.doubleToLongBits(salary);
      //  result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {

        Dish other = (Dish) obj;
       if (name.equals(other.name)) {
           return true;
       }
       return false;
    }


    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", vegetarian=" + vegetarian +
                ", calories=" + calories +
                ", type=" + type +
                '}';
    }

    /*/利用当前对象和传入的目标对象进行比较，若是当前对象比目标对象大，则返回1，那么当前对象会排在目标对象的后面

    　　　　　　　　　　　　　　　　　　    若是当前对象比目标对象小，则返回-1，那么当前对象会排在目标对象的后面

    　　　　　　　　　　　　　　　　　　     若是两个对象相等，则返回0*/
    @Override
    public int compareTo(Dish o) {
        return name.length()-o.getName().length();
    }

    public enum Type { MEAT, FISH, OTHER }

}
