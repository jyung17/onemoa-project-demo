package com.bitcamp.onemoaproject.vo.contest;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ContestTeamField {
  private int tfno; // 모집분야번호
  private int tno; // 팀모집번호
  private String name; // 모집분야
  private String size; // 인원
  private  boolean type; // 상태
  
  public ContestTeamField(String name, String size) {
    this.name = name;
    this.size = size;
  }
}
