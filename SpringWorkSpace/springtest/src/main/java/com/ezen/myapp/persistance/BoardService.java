package com.ezen.myapp.persistance;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.ezen.myapp.model.BoardVo;

/* 마이바트스용 메서드가 있는 곳 */
public interface BoardService {

	//글쓰기
	public int insertBoard(String subject);
	
	//글목록
	public ArrayList<BoardVo> selectAllBoard();
	
	//글보기
	public BoardVo selectOneBoard(String bidx);
	
	//글수정
	public int boardModify(@Param("bidx") String bidx, @Param("subject") String subject);
	
	//글삭제
	public int deleteBoard(int bidx);

}
