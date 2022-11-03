package com.bitcamp.onemoaproject.web.controller.admin;

import com.bitcamp.onemoaproject.service.AdminMemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/")
public class AdminMemberController {
  
  AdminMemberService adminMemberService;
  
  public AdminMemberController(AdminMemberService adminMemberService) {
    System.out.println("AdminMemberController() 호출됨!!");
    System.out.println("adminMemberService.toString() : " + adminMemberService.toString());
    this.adminMemberService = adminMemberService;
  }
  
  @GetMapping("adminmemberlist")
  public void list(Model model) throws Exception {
    model.addAttribute("adminMembers", adminMemberService.list());
    System.out.println(model);
  }
  
  @GetMapping("memberlist")
  public void memberList(Model model) throws Exception {
    model.addAttribute("members", adminMemberService.memberList());
    System.out.println(model);
  }
  
}
