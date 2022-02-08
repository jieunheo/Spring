package com.ezen.myapp.persistance;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.ezen.myapp.model.MemberVo;

/* 마이바트스용 메서드가 있는 곳 */
public interface MemberService {

	//회원 가입
	public int joinMember(@Param("memberName") String memberName, @Param("memberId") String memberId, @Param("memberPw") String memberPw);
	
	//회원 로그인
	public MemberVo loginMember(@Param("memberId") String memberId, @Param("memberPw") String memberPw);
	
	//회원 목록
	public ArrayList<MemberVo> selectAllMember();
	
	//글보기
	//public BoardVo selectOneBoard(String bidx);
	
	//글삭제
	//public int deleteBoard(String bidx);

}
