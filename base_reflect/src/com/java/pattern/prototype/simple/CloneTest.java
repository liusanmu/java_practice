package com.java.pattern.prototype.simple;

/**
 * @author: lsm
 * @description:
 * @create: 2019-09-25 14:14
 */
public class CloneTest {

    public static void main(String[] args) {
        CloneTarget p = new CloneTarget();
        p.name = "Tom";
//        p.list = new ArrayList<CloneTarget>();
//        p.list.add(new CloneTarget());
        p.target = new CloneTarget();
        System.out.println(p.target);

        try {
            CloneTarget obj =  (CloneTarget) p.clone();
            System.out.println(obj.target);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
