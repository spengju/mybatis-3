package com.peng;

import org.apache.ibatis.type.Alias;

import java.util.List;

@Alias("userInfo")
public class UserInfo {

  private int id;
  private String name;
  private List<BlogInfo> blogs;

  public UserInfo() {
  }

  public UserInfo(String name) {
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<BlogInfo> getBlogs() {
    return blogs;
  }

  public void setBlogs(List<BlogInfo> blogs) {
    this.blogs = blogs;
  }

  @Override
  public String toString() {
    return "UserInfo{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", blogs=" + blogs +
      '}';
  }
}
