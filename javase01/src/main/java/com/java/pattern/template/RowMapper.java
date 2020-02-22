package com.java.pattern.template;

import java.sql.ResultSet;

/**
 * @author: lsm
 * @description:
 * @create: 2019-09-27 9:10
 */
public interface RowMapper<T> {

    T mapRow(ResultSet rs, int rowNum) throws Exception;
}
