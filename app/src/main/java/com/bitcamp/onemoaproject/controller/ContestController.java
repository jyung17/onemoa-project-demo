package com.bitcamp.onemoaproject.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bitcamp.onemoaproject.service.ContestService;
import com.bitcamp.onemoaproject.vo.contest.AttachedFile;
import com.bitcamp.onemoaproject.vo.contest.Contest;

@Controller
@RequestMapping("contest")
public class ContestController {

  ServletContext sc;
  ContestService contestService;

  public ContestController(ContestService contestService, ServletContext sc) {
    this.contestService = contestService;
    this.sc = sc;
  }

//  @GetMapping("contestTeam")
//  public String contestTeamList(Model model) throws Exception {
//    model.addAttribute("contests", contestService.list());
//    return "contest/contestTeam";
//  }
  
  @GetMapping("contestTeam")
  public String contestTeamList(Model model, int no) throws Exception {
//    Contest contest = contestService.get(no);
    System.out.println("no = " + no);
    model.addAttribute("contests", contestService.list());
    return "contest/contestTeam";
  }

  // 공모전 디테일
  @PostMapping("contestTeam/detail")
  @ResponseBody
  public Contest contestTeamDetail(int contestNumber) throws Exception {
    Contest contest = contestService.get(contestNumber);
    return contest;
  }

  // 공모전 리스트 출력 (임시 작업중)
  @GetMapping("list")
  public String list(Model model) throws Exception {
    model.addAttribute("contests", contestService.list());
    return "contest/contestList";
  }

  // 공모전 글작성 폼
  @GetMapping("contestform")
  public void form() throws Exception {
    String dirPath2 = sc.getRealPath("/contest/files");
    System.out.println(dirPath2);
  }

  
  // 공모전 글작성
  @PostMapping("add")
  public String add(Contest contest, Part[] files, Part files2, HttpServletRequest request, HttpSession session)
      throws Exception {
    contest.setAttachedFiles(saveAttachedFiles(files));
    contest.setThumbNail(saveThumbNailFile(files2));
    System.out.println(contest);
    contestService.add(contest);

    return "redirect:list";
  }
  
  // 공모전 썸네일 첨부파일 처리
  private String saveThumbNailFile(Part files2) throws IOException {
    String dirPath = sc.getRealPath("/contest/files");
    String filename = UUID.randomUUID().toString(); // 첨부파일의 UUID
    files2.write(dirPath + "/" + filename);
    
    return filename;
  }
  
  // 공모전 일반 첨부파일 처리
  private List<AttachedFile> saveAttachedFiles(Part[] files) throws IOException, ServletException {
    List<AttachedFile> attachedFiles = new ArrayList<>();
    String dirPath = sc.getRealPath("/contest/files");

    for (Part part : files) {
      if (part.getSize() == 0) {
        continue;
      }

      String filename = UUID.randomUUID().toString(); // 첨부파일의 UUID
      String realFilename = part.getSubmittedFileName(); // 첨부파일의 실제파일명 (KakaoTalk_Photo_2022-09-15-20-31-04.jpeg)
      part.write(dirPath + "/" + filename);
      attachedFiles.add(new AttachedFile(filename, realFilename));
    }
    return attachedFiles;
  }
}
