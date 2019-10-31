package com.java.pattern.singleton.lazy.com.java.pattern.singleton.prototype;

/**
 * @author: lsm
 * @description:
 * @create: 2019-09-30 16:12
 */

import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

//@RestController
public class JavaBean {

        @NotNull(message = "姓名不能为空")
        @Size(min = 2,max = 10, message = "姓名长度大于2.小鱼10")
        private String name;

        @Max(value = 80,message = "年龄不能大于18")
        private Integer age;

        @Future(message = "日期应该是未来的")
        private Date date;

        @Pattern(regexp = "(^(\\d{3,4}-)?\\d{7,8})$|(1[3|5|7|8|9]\\d{9})", message = "联系电话格式不正确")
        private String phone;

    }


