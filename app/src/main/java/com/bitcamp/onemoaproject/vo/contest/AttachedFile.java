package com.bitcamp.onemoaproject.vo.contest;

public class AttachedFile {
  private int no;
  private String filepath;
  private String filename;
  private int boardNo;

  public AttachedFile() {}
  
  public AttachedFile(String filepahth) {
    this.filepath = filepahth;
  }

  public AttachedFile(String filepahth, String filename) {
    this.filepath = filepahth;
    this.filename = filename;
  }
  
  @Override
  public String toString() {
    return "AttachedFile{" +
        "no=" + no +
        ", filepath='" + filepath + '\'' +
        ", filename='" + filename + '\'' +
        ", boardNo=" + boardNo +
        '}';
  }
  
  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getFilepath() {
    return filepath;
  }

  public void setFilepath(String filepath) {
    this.filepath = filepath;
  }

  public int getBoardNo() {
    return boardNo;
  }

  public void setBoardNo(int boardNo) {
    this.boardNo = boardNo;
  }
  
  public String getFilename() {
    return filename;
  }
  
  public void setFilename(String filename) {
    this.filename = filename;
  }
}
