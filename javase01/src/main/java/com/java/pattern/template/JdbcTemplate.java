package com.java.pattern.template;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: lsm
 * @description:
 * @create: 2019-09-27 8:59
 */
public class JdbcTemplate {

    private DataSource dataSource;

    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public List<?> execteQuery(String sql, RowMapper<?> rowMapper, Object[] values) {

        ResultSet rs = null;
        PreparedStatement pstmt = null;
        Connection conn = null;
        try {
            // 获取连接
            conn = this.getConnection();

            // 创建语句集
            pstmt = this.getPreparedStatement(conn, sql);

            // 执行语句集，并获取结果集
            rs = this.executeQuery(pstmt, values);

            // 解析语句集
            List<?> result = this.parseResultSet(rs, rowMapper);

//            // 关闭结果集
//            this.closeResultSet(rs);
//            // 关闭语句集
//            this.closeStatement(pstmt);
//            // 关闭连接
//            this.colseConnection(conn);

            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            // 关闭结果集
            try {
                this.closeResultSet(rs);
            } catch (Exception e) {
                e.printStackTrace();
            }
            // 关闭语句集
            try {
                this.closeStatement(pstmt);
            } catch (Exception e) {
                e.printStackTrace();
            }
            // 关闭连接
            try {
                this.colseConnection(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    private Connection getConnection() throws SQLException {

        return this.dataSource.getConnection();
    }

    private PreparedStatement getPreparedStatement(Connection conn, String sql) throws SQLException {

        return conn.prepareStatement(sql);
    }

    private ResultSet executeQuery(PreparedStatement pstmt, Object[] values) throws SQLException {

        for (int i = 0; i < values.length; i++) {
            pstmt.setObject(i, values[i]);

        }
        return pstmt.executeQuery();

    }

    private List<?> parseResultSet(ResultSet rs, RowMapper rowMapper) throws Exception {
        List<Object> result = new ArrayList<>();
        int rowNum = 1;
        while (rs.next()) {
            result.add(rowMapper.mapRow(rs, rowNum++));
        }
        return result;

    }


    private void closeStatement(Statement stmt) throws Exception {
        stmt.close();
    }

    private void closeResultSet(ResultSet rs) throws Exception {
        rs.close();
    }


    //通常把它放到连接池回收
    public void colseConnection(Connection conn) throws SQLException {
        conn.close();
    }

}
