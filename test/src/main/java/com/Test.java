package com;

/**
 * @author: ls
 * @description:
 * @create: 2019-08-08 11:41
 */
public class Test {
    int a;

    public static void main(String[] args) {
      //  System.out.println(a);
        String a = "0123456789";
        String substring = a.substring(1, 8);
        System.out.println(substring);

        StringBuilder sb = new StringBuilder("1345");
        sb.insert(1,"32");
        System.out.println(sb);
    }


}
