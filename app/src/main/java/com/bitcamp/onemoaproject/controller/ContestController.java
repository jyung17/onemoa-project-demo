package com.bitcamp.onemoaproject.controller;

import com.bitcamp.onemoaproject.service.ContestService;
import com.bitcamp.onemoaproject.vo.contest.Contest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("contest")
public class ContestController {
  
  @Autowired
  ContestService contestService;
  
  @GetMapping("contestTeam")
  public String contestTeamList(Model model) throws Exception {
    model.addAttribute("contests", contestService.list());
    return "contest/contestTeam";
  }
  
  @PostMapping("contestTeam/detail")
  @ResponseBody
  public Contest contestTeamDetail(int contestNumber) throws Exception {
    Contest contest = contestService.get(contestNumber);
    return contest;
  }
}
