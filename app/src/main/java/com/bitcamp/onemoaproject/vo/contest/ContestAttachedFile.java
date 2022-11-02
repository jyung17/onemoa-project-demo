package com.bitcamp.onemoaproject.vo.contest;

public class ContestAttachedFile {
  private int ctstFno;
  private String fName;
  private String filepath;
  private int ctstNo;
  
  public ContestAttachedFile() {}
  
  public ContestAttachedFile(String filepath) {
    this.filepath = filepath;
  }
  
  public ContestAttachedFile(String fName, String filepath) {
    this.fName = fName;
    this.filepath = filepath;
  }
  
  @Override
  public String toString() {
    return "ContestAttachedFile [ctstFno=" + ctstFno + ", fName=" + fName + ", filepath=" + filepath
        + ", ctstNo=" + ctstNo + "]";
  }
  
  public int getCtstFno() {
    return ctstFno;
  }
  
  public void setCtstFno(int ctstFno) {
    this.ctstFno = ctstFno;
  }
  
  public String getfName() {
    return fName;
  }
  
  public void setfName(String fName) {
    this.fName = fName;
  }
  
  public String getFilepath() {
    return filepath;
  }
  
  public void setFilepath(String filepath) {
    this.filepath = filepath;
  }
  
  public int getCtstNo() {
    return ctstNo;
  }
  
  public void setCtstNo(int ctstNo) {
    this.ctstNo = ctstNo;
  }
  
  
}
