package com.java.pattern.strategy.order;

import java.lang.annotation.*;

/**
 * @author: lsm
 * @description:
 * @create: 2019-09-27 16:54
 */
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface HandlerType {

    String value();

}
