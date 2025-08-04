package com.peng;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/8/1 15:07
 * @Desc:
 */

@MappedTypes(String.class)
@MappedJdbcTypes({JdbcType.CLOB, JdbcType.INTEGER})
public class PengTypeHandler extends BaseTypeHandler<String> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, Integer.valueOf(parameter));
    }

    @Override
    public String getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int anInt = rs.getInt(columnName);
        return String.valueOf(anInt);
    }

    @Override
    public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int anInt = rs.getInt(columnIndex);
        return String.valueOf(anInt);
    }

    @Override
    public String getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        int anInt = cs.getInt(columnIndex);
        return String.valueOf(anInt);
    }
}
