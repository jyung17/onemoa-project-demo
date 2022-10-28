package com.bitcamp.onemoaproject.vo;

import java.sql.Date;

public class Contest {
  private int ctstno;
  private int orgno;
  private int ctgno;
  private String title;
  private String subCont;
  private Date date;
  private Date sdate;
  private Date edate;
  private int vwcnt;
  private String org;
  private String appl;
  private String cont;
  private String page;
  private int size;
  private String qual;
  private boolean team;
  private int reward;
  
  @Override
  public String toString() {
    return "Contest{" +
        "ctstno=" + ctstno +
        ", orgno=" + orgno +
        ", ctgno=" + ctgno +
        ", title='" + title + '\'' +
        ", subCont='" + subCont + '\'' +
        ", date=" + date +
        ", sdate=" + sdate +
        ", edate=" + edate +
        ", vwcnt=" + vwcnt +
        ", org='" + org + '\'' +
        ", appl='" + appl + '\'' +
        ", cont='" + cont + '\'' +
        ", page='" + page + '\'' +
        ", size=" + size +
        ", qual='" + qual + '\'' +
        ", team=" + team +
        ", reward=" + reward +
        '}';
  }
  
  public int getCtstno() {
    return ctstno;
  }
  
  public void setCtstno(int ctstno) {
    this.ctstno = ctstno;
  }
  
  public int getOrgno() {
    return orgno;
  }
  
  public void setOrgno(int orgno) {
    this.orgno = orgno;
  }
  
  public int getCtgno() {
    return ctgno;
  }
  
  public void setCtgno(int ctgno) {
    this.ctgno = ctgno;
  }
  
  public String getTitle() {
    return title;
  }
  
  public void setTitle(String title) {
    this.title = title;
  }
  
  public String getSubCont() {
    return subCont;
  }
  
  public void setSubCont(String subCont) {
    this.subCont = subCont;
  }
  
  public Date getDate() {
    return date;
  }
  
  public void setDate(Date date) {
    this.date = date;
  }
  
  public Date getSdate() {
    return sdate;
  }
  
  public void setSdate(Date sdate) {
    this.sdate = sdate;
  }
  
  public Date getEdate() {
    return edate;
  }
  
  public void setEdate(Date edate) {
    this.edate = edate;
  }
  
  public int getVwcnt() {
    return vwcnt;
  }
  
  public void setVwcnt(int vwcnt) {
    this.vwcnt = vwcnt;
  }
  
  public String getOrg() {
    return org;
  }
  
  public void setOrg(String org) {
    this.org = org;
  }
  
  public String getAppl() {
    return appl;
  }
  
  public void setAppl(String appl) {
    this.appl = appl;
  }
  
  public String getCont() {
    return cont;
  }
  
  public void setCont(String cont) {
    this.cont = cont;
  }
  
  public String getPage() {
    return page;
  }
  
  public void setPage(String page) {
    this.page = page;
  }
  
  public int getSize() {
    return size;
  }
  
  public void setSize(int size) {
    this.size = size;
  }
  
  public String getQual() {
    return qual;
  }
  
  public void setQual(String qual) {
    this.qual = qual;
  }
  
  public boolean isTeam() {
    return team;
  }
  
  public void setTeam(boolean team) {
    this.team = team;
  }
  
  public int getReward() {
    return reward;
  }
  
  public void setReward(int reward) {
    this.reward = reward;
  }
}
