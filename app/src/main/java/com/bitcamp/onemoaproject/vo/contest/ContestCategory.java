package com.bitcamp.onemoaproject.vo.contest;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class ContestCategory {
  private int no;
  private String categoryName;
  
  @Override
  public String toString() {
    return "ContestCategory{" +
        "no=" + no +
        ", categoryName='" + categoryName + '\'' +
        '}';
  }
  
  public int getNo() {
    return no;
  }
  
  public void setNo(int no) {
    this.no = no;
  }
  
  public String getCategoryName() {
    return categoryName;
  }
  
  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }
}
