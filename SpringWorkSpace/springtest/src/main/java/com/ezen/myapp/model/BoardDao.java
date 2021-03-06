package com.ezen.myapp.model;

import java.sql.*;
import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.myapp.persistance.BoardService;

/*  */
@Service("bd")
public class BoardDao /* extends Object //Object 상속. 기본값으로 생략되어 있음 */ {
	
	//Connection        conn;  //connection
	PreparedStatement pstmt; //PreparedStatement
	ResultSet         rs;    //ResultSet
	BoardService      bs;

	/* bean 객체로 등록된 클래스를 이곳으로 주입 */
	//@Autowired
	//SqlSessionTemplate sqlSession;

	@Autowired
	public BoardDao(SqlSessionTemplate sqlSession) {

		System.out.println("sqlSession: "+sqlSession);
		
		//super(); //부모의 생성자를 실행. 기본값으로 생략되어 있음
		
		/* DB 연결 */	
		//외부에서 만들어진 데이터를 가져와 연결함
		bs = sqlSession.getMapper(BoardService.class);
		
	}

	
	/* INSERT */
	public int insertBoard(String subject) {
		
		/* mybatis용 메소드가 있는 인터페이스를 가져옴 */
		int value = bs.insertBoard(subject);
		
		return value;
		
	}
	
//	public int insertBoard(String subject) {
//		
//		//1. 결과를 담을 변수 생성
//		int exec = 0;
//		
//		//2. 쿼리문 작성
//		String sql = "INSERT INTO boardtest(subject) values(?)";
//		try {
//			
//			pstmt = conn.prepareStatement(sql); //쿼리문 담기
//			pstmt.setString(1, subject); //해당 ?에 값 삽입
//			
//			//3. 쿼리문 실행
//			exec = pstmt.executeUpdate(); //실행 후 결과 값(성공:1, 실패:0)
//			System.out.println(pstmt);
//			
//			//4. pstmt 닫기
//			pstmt.close();
//			
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//			
//		} finally {
//			/*
//			try {
//				
//				//5. db 닫기
//				if(!conn.isClosed())  conn.close();
//				
//			} catch (SQLException e) { e.printStackTrace(); }
//			*/
//		}
//		
//		//6. 결과값 리턴
//		return exec;
//	}
	
	/* SELECT All */
	public ArrayList<BoardVo> selectAllBoard() {
		
		//1. 결과를 담을 변수 생성
		ArrayList<BoardVo> alist = bs.selectAllBoard();
		
		return alist;
		
	}
//	public ArrayList<BoardVo> selectAllBoard() {
//		
//		System.out.println("sqlSession: " + sqlSession);
//		
//		//1. 결과를 담을 변수 생성
//		ArrayList<BoardVo> alist = null;
//		
//		//2. 쿼리문 작성
//		String sql = "SELECT * FROM boardtest ORDER BY bidx ASC";
//		try {
//			
//			pstmt = conn.prepareStatement(sql);
//			
//			//3. 쿼리문 실행
//			rs = pstmt.executeQuery(); //실행 후 결과 담기
//			
//			//4. 값이 있는지 확인
//			while(rs.next()) {
//				
//				//alist가 생성되지 않았으면 생성
//				if(alist == null) alist = new ArrayList<BoardVo>();
//				
//				//vo객체에 값 넣기
//				BoardVo vo = new BoardVo();
//				vo.setBidx(rs.getInt("bidx"));
//				vo.setSubject(rs.getString("subject"));
//				
//				//alist에 vo 추가
//				alist.add(vo);
//				
//			}
//			
//			//5. pstmt 닫기
//			pstmt.close();
//			
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//			
//		} finally {
//			/*
//			try {
//				
//				//6. db 닫기
//				conn.close();
//				
//			} catch (SQLException e) { e.printStackTrace(); }
//			*/
//		}
//		
//		//6. 결과값 리턴
//		return alist;
//		
//	}
	
	/* SELECT */
	public BoardVo selectOneBoard(String bidx) {
		
		BoardVo vo = bs.selectOneBoard(bidx);
		
		return vo;
		
	}
//	public BoardVo selectOneBoard(String bidx) {
//		
//		//1. 결과를 담을 변수 생성
//		BoardVo vo = null;
//		
//		//2. 쿼리문 작성
//		String sql = "SELECT * FROM boardtest WHERE bidx = ?";
//		try {
//			
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, bidx);
//			
//			//3. 쿼리문 실행
//			rs = pstmt.executeQuery(); //실행 후 결과 담기
//			
//			//4. 값이 있는지 확인
//			if(rs.next()) {
//				
//				vo = new BoardVo();
//				//값 넣기
//				vo.setBidx(rs.getInt("bidx"));
//				vo.setSubject(rs.getString("subject"));
//				
//			}
//			
//			//5. pstmt 닫기
//			pstmt.close();
//			
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//			
//		} finally {
//			/*
//			try {
//				
//				//6. db 닫기
//				conn.close();
//				
//			} catch (SQLException e) { e.printStackTrace(); }
//			*/
//		}
//		
//		//6. 결과값 리턴
//		return vo;
//		
//	}
	
	/* UPDATE */
	public BoardVo boardModify(String bidx, String subject) {
		
		BoardVo result = null;
		
		BoardVo vo = bs.selectOneBoard(bidx);
		
		if(vo != null) {
			
			if(bs.boardModify(bidx, subject) != 0) result = bs.selectOneBoard(bidx);
			
		}
		
		return result;
		
	}
	
	/* DELETE */
	public int deleteBoard(String bidx) {
		
		int result = 0;
		int bidx_int = Integer.parseInt(bidx);
		
		BoardVo vo = bs.selectOneBoard(bidx);
		
		if(vo != null) {
			
			if(bs.deleteBoard(bidx_int) != 0) result = bs.deleteBoard(bidx_int);
			
		}
		
		return result;
		
	}
	
}
