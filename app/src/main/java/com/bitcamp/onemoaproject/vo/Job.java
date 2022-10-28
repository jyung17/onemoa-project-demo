package com.bitcamp.onemoaproject.vo;

public class Job {
  private int jobNo;
  private String jobName;
  
  @Override
  public String toString() {
    return "Job{" +
        "no=" + jobNo +
        ", jobName='" + jobName + '\'' +
        '}';
  }
  
  public int getNo() {
    return jobNo;
  }
  
  public void setNo(int jobNo) {
    this.jobNo = jobNo;
  }
  
  public String getJobName() {
    return jobName;
  }
  
  public void setJobName(String jobName) {
    this.jobName = jobName;
  }
}


