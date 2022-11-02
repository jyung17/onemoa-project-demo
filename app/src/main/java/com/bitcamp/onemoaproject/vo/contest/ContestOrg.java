package com.bitcamp.onemoaproject.vo.contest;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class ContestOrg {
  private int no;
  private String orgName;
  
  public ContestOrg(int no, String orgName) {
    this.no = no;
    this.orgName = orgName;
  }
  
  public int getNo() {
    return no;
  }
  
  public void setNo(int no) {
    this.no = no;
  }
  
  public String getOrgName() {
    return orgName;
  }
  
  public void setOrgName(String orgName) {
    this.orgName = orgName;
  }
}
