package com.java.pattern.template.dao;

import com.java.pattern.template.JdbcTemplate;
import com.java.pattern.template.RowMapper;
import com.java.pattern.template.entity.Member;

import java.sql.ResultSet;
import java.util.List;

/**
 * @author: lsm
 * @description:
 * @create: 2019-09-27 9:39
 */
public class MemberDao {

    //为什么不继承，主要是为了解耦
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(null);

    public List<?> query() {
        String sql = "select * from t_member";
        return jdbcTemplate.execteQuery(sql, new RowMapper<Member>() {
            @Override
            public Member mapRow(ResultSet rs, int rowNum) throws Exception {
                Member member = new Member();
                member.setUsername(rs.getString("username"));
                member.setPassword(rs.getString("password"));
                member.setAge(rs.getInt("age"));
                member.setAddr(rs.getString("addr"));
                return member;
            }
        }, null);
    }


}
