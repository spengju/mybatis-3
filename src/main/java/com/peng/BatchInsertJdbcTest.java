package com.peng;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 大都督周瑜
 * 微信ID: dadudu6789
 * 专注帮助程序员提升技术实力，升职涨薪，面试跳槽
 */
public class BatchInsertJdbcTest {

  public static void main(String[] args) {
//    String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/my_db";
    String jdbcUrl = "jdbc:mysql://127.0.0.1:3308/my_db";
    String username = "root";
//    String password = "Zhouyu123456...";
    String password = null;

    try(Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {

      String sql = "insert into user_info (name) values (?)";
      PreparedStatement preparedStatement = connection.prepareStatement(sql);

      ArrayList<String> names = new ArrayList<>();
      names.add("dadudu");
      names.add("zhouyu");

      for (String name : names) {
        preparedStatement.setString(1, name);
        preparedStatement.addBatch();
      }

      int[] ints = preparedStatement.executeBatch();
      for (int anInt : ints) {
        System.out.println(anInt);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
