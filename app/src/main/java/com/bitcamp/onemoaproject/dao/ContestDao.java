package com.bitcamp.onemoaproject.dao;

import com.bitcamp.onemoaproject.vo.contest.Contest;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ContestDao {
  
  List<Contest> findAll();
  
  List<Contest> findByTeam(boolean no);
  
  Contest findByNo(int contestNumber);
  
  int insert(Contest contest);
  
  int insertFiles(Contest contest);
  
  int update(Contest contest);
  
  int updateThumbnailFile(Contest contest);
  
  int delete(int ctstno);
  
  int deleteFiles(int ctstno);
}
