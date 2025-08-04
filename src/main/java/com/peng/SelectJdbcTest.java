package com.peng;

import java.sql.*;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/7/31 16:37
 * @Desc:
 */
public class SelectJdbcTest {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/my_db";
        String username = "root";
        String password = "peng1234";

        // 1. 建立数据库连接
        // 面试题：MyBatis中是在什么时候创建的数据库连接？
        try(Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {

            // 2. 创建PreparedStatement
            // 面试题：PreparedStatement和Statement对象的区别？
            // 高级面试题：MyBatis中PreparedStatementHandler的作用是什么？
            String sql = "select * from user_info where ${col} = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 1);


            // 3. 执行查询操作
            ResultSet resultSet = preparedStatement.executeQuery();

            ResultSetMetaData metaData = resultSet.getMetaData();
            System.out.println(metaData.getColumnName(1));
            System.out.println(metaData.getColumnType(1));

            // 4. 获取查询结果
            // 面试题：MyBatis中TypeHandler的作用是什么？
            // 面试题：MyBatis中ResultMap的作用是什么？
            // 高级面试题：MyBatis中的AutoMapping是什么意思？
            if (resultSet.next()) {
                int id = resultSet.getInt("user_id"); // userId
                String name = resultSet.getString("name");

                UserInfo userInfo = new UserInfo();
                userInfo.setId(id);
                userInfo.setName(name);

                System.out.println(userInfo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

