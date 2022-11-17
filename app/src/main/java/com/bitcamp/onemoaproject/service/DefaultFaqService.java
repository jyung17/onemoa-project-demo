package com.bitcamp.onemoaproject.service;

import com.bitcamp.onemoaproject.dao.FaqDao;
import com.bitcamp.onemoaproject.vo.Faq;
import com.bitcamp.onemoaproject.vo.paging.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Service
public class DefaultFaqService implements FaqService {

  @Autowired
  FaqDao faqDao;

  @Override
  public void add(Faq faq) throws Exception {
    // 1) 게시글 등록
    if (faqDao.insert(faq) == 0) {
      throw new Exception("게시글 등록 실패!");
    }
  }

  @Override
  public boolean update(Faq faq) throws Exception {
    // 1) 게시글 변경
    if (faqDao.update(faq) == 0) {
      return false;
    }
    return true;
  }

  @Override
  public Faq get(int no) throws Exception {
    return faqDao.findByNo(no); // 첨부파일 데이터까지 조인하여 select를 한 번만 실행한다.
  }

  @Override
  public boolean delete(int no) throws Exception {
    return faqDao.delete(no) > 0;
  }

  @Override
  public List<Faq> list() throws Exception {
    return faqDao.findAll();
  }

  public List<Faq> list(String type) {
    return faqDao.findAll(type);
  }

  // 페이징
  @Override
  public List<Map<String, Object>> list(Criteria cri) throws Exception {
    return faqDao.findAllList(cri);
  }

  @Override
  public int listCount() throws ExecutionException {
    return faqDao.findAllCount();
  }
}








