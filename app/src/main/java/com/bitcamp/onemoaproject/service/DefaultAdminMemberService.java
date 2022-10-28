package com.bitcamp.onemoaproject.service;

import com.bitcamp.onemoaproject.dao.AdminMemberDao;
import com.bitcamp.onemoaproject.vo.AdminMember;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultAdminMemberService implements AdminMemberService {
  
  @Autowired
  AdminMemberDao adminMemberDao;
  
  @Override
  public List<AdminMember> list() throws Exception {
    return adminMemberDao.findAll();
  }
}
