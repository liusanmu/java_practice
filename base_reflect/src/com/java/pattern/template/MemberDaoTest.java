package com.java.pattern.template;

import com.java.pattern.template.dao.MemberDao;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lsm
 * @description:
 * @create: 2019-09-27 9:45
 */
public class MemberDaoTest {

    public static void main(String[] args) {

        MemberDao memberDao = new MemberDao();
        memberDao.query();

    }

    @Test
    public void test() {

        List arrayList = new ArrayList();
        arrayList.add("aaaa");
        arrayList.add(100);

        for (int i = 0; i < arrayList.size(); i++) {
            String item = (String) arrayList.get(i);

            // ("泛型测试","item = " + item);
        }
    }
}
