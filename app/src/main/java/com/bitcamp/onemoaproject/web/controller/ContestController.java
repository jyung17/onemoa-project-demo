package com.bitcamp.onemoaproject.web.controller;

import com.bitcamp.onemoaproject.vo.contest.ContestAttachedFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bitcamp.onemoaproject.service.ContestService;
import com.bitcamp.onemoaproject.vo.contest.Contest;

@Controller
@RequestMapping("contest")
public class ContestController {

  @Autowired
  ServletContext sc;
  @Autowired
  ContestService contestService;

  public ContestController(ContestService contestService, ServletContext sc) {
    this.contestService = contestService;
    this.sc = sc;
  }
  
  @GetMapping("contestTeam")
  public String contestTeamList(Model model, int no) throws Exception {
    if (no == 1) {
      model.addAttribute("contests", contestService.listTeam(false));
      return "contest/contestTeam";
    } else if (no == 2) {
      model.addAttribute("contests", contestService.listTeam(true));
      return "contest/contestTeam";
    }
    return "contest/contestTeam";
  }

  // 공모전 디테일
  @PostMapping("contestTeam/detail")
  @ResponseBody
  public Contest contestTeamDetail(int contestNumber) throws Exception {
    Contest contest = contestService.get(contestNumber);
    return contest;
  }

  // 관리자 페이지용 공모전 리스트 출력 (임시 작업중)
  @GetMapping("contestList")
  public String list(Model model) throws Exception {
    model.addAttribute("contests", contestService.list());
    return "contest/contestList";
  }

  // 공모전 디테일
  @GetMapping("contestDetail")
  public Contest contestDetail(int ctstNo) throws Exception {
    Contest contest = contestService.get(ctstNo);
    return contest;
  }

  // 관리자 페이지용 공모전 글작성 폼
  @GetMapping("contestForm")
  public void form() throws Exception {
    String dirPath2 = sc.getRealPath("/contest/files");
    System.out.println(dirPath2);
  }
  
  // 관리자 페이지용 공모전 글수정
  @PostMapping("contestUpdate")
  public String update(Contest contest, Part[] files, Part files2, HttpSession session) throws Exception {
    contest.setContestAttachedFiles(saveAttachedFiles(files));
    contest.setThumbNail(saveThumbNailFile(files2));
  
    System.out.println(contest);
    
    if (!contestService.update(contest)) {
      throw new Exception("공모전 게시글을 변경할 수 없습니다.");
    }
    
    return "redirect:contestList";
  }

  // 관리자 페이지용 공모전 글작성
  @PostMapping("contestAdd")
  public String add(Contest contest, Part[] files, Part files2, HttpServletRequest request, HttpSession session)
      throws Exception {
    contest.setContestAttachedFiles(saveAttachedFiles(files));
    contest.setThumbNail(saveThumbNailFile(files2));
    System.out.println(contest);
    contestService.add(contest);

    return "redirect:contestList";
  }

  // 공모전 썸네일 첨부파일 처리
  private String saveThumbNailFile(Part files2) throws IOException {
    String dirPath = sc.getRealPath("/contest/files");
    
    if (files2.getSize() != 0) {
      String filename = UUID.randomUUID().toString(); // 첨부파일의 UUID
      files2.write(dirPath + "/" + filename);
  
      return filename;
    }
    return null;
  }

  // 공모전 일반 첨부파일 처리
  private List<ContestAttachedFile> saveAttachedFiles(Part[] files) throws IOException, ServletException {
    List<ContestAttachedFile> contestAttachedFiles = new ArrayList<>();
    String dirPath = sc.getRealPath("/contest/files");

    for (Part part : files) {
      if (part.getSize() == 0) {
        continue;
      }

      String filename = UUID.randomUUID().toString(); // 첨부파일의 UUID
      String realFilename = part.getSubmittedFileName(); // 첨부파일의 실제파일명 (KakaoTalk_Photo_2022-09-15-20-31-04.jpeg)
      part.write(dirPath + "/" + filename);
      contestAttachedFiles.add(new ContestAttachedFile(realFilename, filename));
    }
    return contestAttachedFiles;
  }
  
  // 공모전 게시글 삭제
  @GetMapping("contestDelete")
  public String delete(int ctstno, HttpSession session) throws Exception {

    if (!contestService.delete(ctstno)) {
      throw new Exception("게시글을 삭제할 수 없습니다.");
    }

    return "redirect:contestList";
  }
//
//  @GetMapping("fileDelete")
//  public String fileDelete(int no, HttpSession session) throws Exception {
//    // 첨부파일 정보를 가져온다.
//    AttachedFile attachedFile = boardService.getAttachedFile(no);
//
//    // 게시글의 작성자가 로그인 사용자인지 검사한다.
//    Member loginMember = (Member) session.getAttribute("loginMember");
//    Board board = boardService.get(attachedFile.getBoardNo());
//    if (board.getWriter().getNo() != loginMember.getNo()) {
//      throw new Exception("게시글 작성자가 아닙니다.");
//    }
//
//    // 첨부파일을 삭제한다.
//    if (!boardService.deleteAttachedFile(no)) {
//      throw new Exception("게시글 첨부파일을 삭제할 수 없습니다.");
//    }
//
//    return "redirect:detail?no=" + board.getNo(); // Board 객체를 여기서도 사용해야해서 Board 객체를 생
//  }
}
