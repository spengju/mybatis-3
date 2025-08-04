package com.peng.mapper;

import com.peng.UserInfo;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.cursor.Cursor;

import java.util.List;
import java.util.Map;

/**
 * 大都督周瑜（微信ID: dadudu6789，交个朋友，一起交流技术）
 */
public interface UserMapper{

  public UserInfo getUserInfo(int userId);

  @Select("select * from user_info;")
  public Cursor<UserInfo> getAllUser();

  @Select("select * from user_info;")
  @MapKey("name")
  public Map<String, UserInfo> selectAllUser();

//  public UserInfo getUserInfoAndBlogInfo(int userId);

  public void insertUser(UserInfo userInfo);

  public void insertUserList(List<UserInfo> userInfo);

}
