package com.ezen.myapp.model;

import java.sql.*;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

/*  */
@Service("bd")
public class BoardDao /* extends Object //Object 상속. 기본값으로 생략되어 있음 */ {
	
	Connection        conn;  //connection
	PreparedStatement pstmt; //PreparedStatement
	ResultSet         rs;    //ResultSet

	/* bean 객체로 등록된 클래스를 이곳으로 주입 */
	@Autowired
	public BoardDao(DriverManagerDataSource dataSource) {

		System.out.println("dataSource: "+dataSource);
		
		/* super(); //부모의 생성자를 실행. 기본값으로 생략되어 있음 */
		try {
			
			/* DB 연결 */	
			//외부에서 만들어진 데이터를 가져와 연결함
			conn = dataSource.getConnection(); //DB 연결
			
		} catch (SQLException e) { e.printStackTrace(); }
		
	}
	
	/* INSERT */
	public int insertBoard(String subject) {
		
		//1. 결과를 담을 변수 생성
		int exec = 0;
		
		//2. 쿼리문 작성
		String sql = "INSERT INTO boardtest(subject) values(?)";
		try {
			
			pstmt = conn.prepareStatement(sql); //쿼리문 담기
			pstmt.setString(1, subject); //해당 ?에 값 삽입
			
			//3. 쿼리문 실행
			exec = pstmt.executeUpdate(); //실행 후 결과 값(성공:1, 실패:0)
			System.out.println(pstmt);
			
			//4. pstmt 닫기
			pstmt.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			/*
			try {
				
				//5. db 닫기
				if(!conn.isClosed())  conn.close();
				
			} catch (SQLException e) { e.printStackTrace(); }
			*/
		}
		
		//6. 결과값 리턴
		return exec;
	}
	
	/* SELECT All */
	public ArrayList<BoardVo> selectAllBoard() {
		
		//1. 결과를 담을 변수 생성
		ArrayList<BoardVo> alist = null;
		
		//2. 쿼리문 작성
		String sql = "SELECT * FROM boardtest ORDER BY bidx ASC";
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			//3. 쿼리문 실행
			rs = pstmt.executeQuery(); //실행 후 결과 담기
			
			//4. 값이 있는지 확인
			while(rs.next()) {
				
				//alist가 생성되지 않았으면 생성
				if(alist == null) alist = new ArrayList<BoardVo>();
				
				//vo객체에 값 넣기
				BoardVo vo = new BoardVo();
				vo.setBidx(rs.getInt("bidx"));
				vo.setSubject(rs.getString("subject"));
				
				//alist에 vo 추가
				alist.add(vo);
				
			}
			
			//5. pstmt 닫기
			pstmt.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			/*
			try {
				
				//6. db 닫기
				conn.close();
				
			} catch (SQLException e) { e.printStackTrace(); }
			*/
		}
		
		//6. 결과값 리턴
		return alist;
		
	}
	
	/* SELECT */
	public BoardVo selectOneBoard(String bidx) {
		
		//1. 결과를 담을 변수 생성
		BoardVo vo = null;
		
		//2. 쿼리문 작성
		String sql = "SELECT * FROM boardtest WHERE bidx = ?";
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bidx);
			
			//3. 쿼리문 실행
			rs = pstmt.executeQuery(); //실행 후 결과 담기
			
			//4. 값이 있는지 확인
			if(rs.next()) {
				
				vo = new BoardVo();
				//값 넣기
				vo.setBidx(rs.getInt("bidx"));
				vo.setSubject(rs.getString("subject"));
				
			}
			
			//5. pstmt 닫기
			pstmt.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			/*
			try {
				
				//6. db 닫기
				conn.close();
				
			} catch (SQLException e) { e.printStackTrace(); }
			*/
		}
		
		//6. 결과값 리턴
		return vo;
		
	}
	
	/* DELETE */
	public boolean deleteBoard(String bidx) {
		
		//1. 값이 있는지 확인
		String sql = "SELECT * FROM boardtest WHERE bidx = ?";
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bidx);
			
			//2. 쿼리문 실행
			rs = pstmt.executeQuery(); //실행 후 결과 담기
			
			//3. 결과의 따른 return
			if(rs.next()) {
				
				sql = "DELETE boardtest WHERE bidx = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, bidx);

				//5. pstmt 닫기
				pstmt.close();
				return true;
				
			} else {

				//5. pstmt 닫기
				pstmt.close();
				return false;
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
			
		} finally {
			/*
			try {
				
				//6. db 닫기
				conn.close();
				
			} catch (SQLException e) { e.printStackTrace(); }
			*/
		}
		
	}
	
}