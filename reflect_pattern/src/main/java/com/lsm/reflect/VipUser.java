package com.lsm.reflect;/**
 * @author: lsm
 * @description:
 * @create: 2019-09-16 12:08
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author: ls
 * @description:
 * @create: 2019-09-16 12:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VipUser extends User {

    private String leave;

    public void speack() {

        System.out.println("我是vip");
    }

}
