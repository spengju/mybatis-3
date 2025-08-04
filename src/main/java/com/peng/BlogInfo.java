package com.peng;

/**
 * 大都督周瑜
 * 微信ID: dadudu6789
 * 专注帮助程序员提升技术实力，升职涨薪，面试跳槽
 */
public class BlogInfo {
  private int id;
  private int userId;
  private String title;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  @Override
  public String toString() {
    return "BlogInfo{" +
      "id=" + id +
      ", userId=" + userId +
      ", title='" + title + '\'' +
      '}';
  }
}
