package com.peng;

import com.peng.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: spengju
 * @Slogan: Day day no bug.
 * @Date: 2025/7/31 16:46
 * @Desc:
 */
public class Main {
    public static void main(String[] args) throws IOException {

        // 1、解析配置文件
        String resource = "config/mybatis-config-simple.xml";
//        String resource = "/Users/shipengju/Documents/spengju/mybatis-3/src/main/resources/config/mybatis-config-simple.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2、生成UserMapper代理对象
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {

            // 3、执行SQL
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            //代理对象执行方法
            UserInfo userInfo = mapper.getUserInfo(1);

            System.out.println(userInfo);
//
//      UserInfo userInfo1 = new UserInfo();
//      userInfo1.setName("xxxx");
//      mapper.insertUser(userInfo1);
//      System.out.println(userInfo1.getId());

        }
    }
}
