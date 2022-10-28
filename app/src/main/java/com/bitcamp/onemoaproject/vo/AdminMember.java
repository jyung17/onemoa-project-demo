package com.bitcamp.onemoaproject.vo;

public class AdminMember {
  private int no;
  private String email;
  private String password;
  
  @Override
  public String toString() {
    return "AdminMember{" +
        "no=" + no +
        ", email='" + email + '\'' +
        ", password='" + password + '\'' +
        '}';
  }
  
  public int getNo() {
    return no;
  }
  
  public void setNo(int no) {
    this.no = no;
  }
  
  public String getEmail() {
    return email;
  }
  
  public void setEmail(String email) {
    this.email = email;
  }
  
  public String getPassword() {
    return password;
  }
  
  public void setPassword(String password) {
    this.password = password;
  }
}
