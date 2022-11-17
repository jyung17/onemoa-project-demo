package com.bitcamp.onemoaproject.service;

import com.bitcamp.onemoaproject.vo.contest.Contest;
import com.bitcamp.onemoaproject.vo.contest.ContestAttachedFile;
import com.bitcamp.onemoaproject.vo.contest.ContestTeam;
import com.bitcamp.onemoaproject.vo.contest.ContestTeamField;
import com.bitcamp.onemoaproject.vo.contest.ContestTeamFieldMember;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public interface ContestService {
  // 공모전 리스트
  List<Map<String, Object>> list(Map map) throws Exception;
  // 공모전의 글 개수 조회
  int listCount() throws ExecutionException;
  // 공모전 리스트
  List<Contest> list2(String no, String ono, String sortCd, String sortEd, String sortVw, String sortRw) throws Exception;
  // 공모전 상세정보
  Contest get(int ctstNo) throws Exception;
  // 공모전 팀원구해요
  List<ContestTeam> getTeamList(int contestNumber);
  // 공모전 등록
  void add(Contest contest) throws Exception;
  // 공모전 수정
  boolean update(Contest contest) throws Exception;
  // 공모전 삭제
  boolean delete(int ctstno) throws Exception;
  // 첨부파일번호로 파일 검색
  ContestAttachedFile getContestAttachedFile(int fileNo) throws Exception;
  // 첨부파일 번호로 첨부파일 삭제
  boolean contestDeleteAttachedFile(int fileNo) throws Exception;
  // 팀(팀장) 등록
  void addTeam(ContestTeam contestTeam) throws Exception;
  // 팀장 상세 정보 조회
  ContestTeam getTeamReader(int contestNo, int memberNo) throws Exception;
  // 팀 모집분야 조회
  List<ContestTeamField> getTeamField(int teamNo) throws Exception;
  // 팀원모집분야지원자 조회
  List<ContestTeamField> getFieldMember(int fieldNo) throws Exception;
  // 팀원 지원하기 지원자 등록 + 포트폴리오 등록
  void addFieldMember(ContestTeamFieldMember contestTeamFieldMember) throws Exception;
  // 공모전 팀원 상세보기(지원자보기)
  ContestTeamFieldMember getFieldMemberDetail(int fmNo) throws Exception;
  
  // 공모전 팀원 채택하기
  boolean updateFieldMemberType(int fmNo, String booleanValue) throws Exception;
  
  // 공모전 조회수 증가
  int addViewCount(int no) throws Exception;
  
  // 메인페이지 인기 공모전
  List<Contest> listMain();
  
  // 마이페이지 공모전 팀전 참가내역
  List<Contest> myContestList(int mno);
}
