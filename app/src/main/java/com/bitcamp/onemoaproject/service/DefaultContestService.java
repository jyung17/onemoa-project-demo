package com.bitcamp.onemoaproject.service;

import com.bitcamp.onemoaproject.dao.ContestDao;
import com.bitcamp.onemoaproject.vo.contest.Contest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DefaultContestService implements ContestService{
  
  @Autowired
  ContestDao contestDao;
  
  @Override
  public List<Contest> list() throws Exception {
    return contestDao.findAll();
  }
  
  @Override
  public Contest get(int no) throws Exception {
    return contestDao.findByNo(no);
  }
  
  @Transactional
  @Override
  public void add(Contest contest) throws Exception {
    // 1) 게시글 등록
    if (contestDao.insert(contest) == 0) {
      throw new Exception("게시글 등록 실패!");
    }
    // 2) 첨부파일 등록
    if (contest.getAttachedFiles().size() > 0) {
      System.out.println("contest = " + contest);
      contestDao.insertFiles(contest);
    }
  }
}
