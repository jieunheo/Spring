package com.ezen.myapp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

import com.ezen.myapp.persistance.BoardService;
import com.ezen.myapp.persistance.MemberService;

/*
 * 서비스로 등록
 * md 객체 생성을 위해 사용
 * 
 * Repository를 사용하기도 함
 */
@Service("md")
public class MemberDao {
	
	//Connection        conn;  //connection
	//PreparedStatement pstmt; //PreparedStatement
	//ResultSet         rs;    //ResultSet
	
	MemberService      ms;

	/* bean 객체로 등록된 클래스를 이곳으로 주입 */
	@Autowired
	public MemberDao(SqlSessionTemplate sqlSession) {
		
		System.out.println("sqlSession: "+sqlSession);
		
		/* super(); //부모의 생성자를 실행. 기본값으로 생략되어 있음 */
		
		/* DB 연결 */	
		//외부에서 만들어진 데이터를 가져와 연결함
		ms = sqlSession.getMapper(MemberService.class);
		
	}
	
	/* SELECT All */
	public ArrayList<MemberVo> selectAllMember() {
		
		//1. 결과를 담을 변수 생성
		ArrayList<MemberVo> alist = ms.selectAllMember();
		
		return alist;
		
	}
//	public ArrayList<MemberVo> selectAllMember() {
//		
//		//1. 결과를 담을 변수 생성
//		ArrayList<MemberVo> alist = null;
//		
//		//2. 쿼리문 작성
//		String sql = "SELECT * FROM member ORDER BY midx ASC";
//		try {
//			
//			pstmt = conn.prepareStatement(sql);
//			
//			//3. 쿼리문 실행
//			rs = pstmt.executeQuery(); //실행 후 결과 담기
//			
//			//4. 값이 있는지 확인
//			while(rs.next()) {
//				//alist가 생성되지 않았으면 생성
//				if(alist == null) alist = new ArrayList<MemberVo>();
//				
//				//vo객체에 값 넣기
//				MemberVo vo = new MemberVo();
//				vo.setMidx(rs.getInt("midx"));
//				vo.setMemberId(rs.getString("memberId"));
//				vo.setMemberPw(rs.getString("memberPw"));
//				vo.setMemberName(rs.getString("memberName"));
//				vo.setWriteday(rs.getString("writeday"));
//				vo.setDelYN(rs.getString("delYN"));
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
	
	/* Login */
	public MemberVo loginMember(String memberId, String memberPw) {
		
		//MemberVo vo = ms.loginMember(memberId, memberPw);
		
		//HashMap으로 넘기기
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("memberId", memberId);
		hm.put("memberPw", memberPw);
		
		MemberVo vo = ms.loginMember(hm);
		
		return vo;
		
	}
//	public MemberVo loginMember(String memberId, String memberPw) {
//		
//		//1. 결과를 담을 변수 생성
//		MemberVo vo = null;
//		
//		//2. 쿼리문 작성
//		String sql = "SELECT * FROM member WHERE memberId = ? AND memberPw = ?";
//		try {
//			
//			pstmt = conn.prepareStatement(sql);
//			
//			//3. 쿼리문 실행
//			pstmt.setString(1, memberId);
//			pstmt.setString(2, memberPw);
//			rs = pstmt.executeQuery(); //실행 후 결과 담기
//			
//			//4. 값이 있는지 확인
//			if(rs.next()) {
//
//				//vo객체에 값 넣기
//				vo = new MemberVo();
//				
//				vo.setMidx(rs.getInt("midx"));
//				vo.setMemberId(rs.getString("memberId"));
//				vo.setMemberPw(rs.getString("memberPw"));
//				vo.setMemberName(rs.getString("memberName"));
//				vo.setWriteday(rs.getString("writeday"));
//				vo.setDelYN(rs.getString("delYN"));
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
	
	/* Join */
	public MemberVo joinMember(String memberName, String memberId, String memberPw) {
		
		MemberVo vo = null;
		int result = ms.joinMember(memberName, memberId, memberPw);
		
		if(result != 0) vo = ms.loginMember(memberId, memberPw);
		
		return vo;
	}
//	public MemberVo joinMember(String memberName, String memberId, String memberPw) {
//		
//		//1. 결과를 담을 변수 생성
//		MemberVo vo = null;
//		
//		//2. 쿼리문 작성
//		String sql = "INSERT INTO member(memberName, memberId, memberPw) VALUES(?,?,?)";
//		try {
//			
//			pstmt = conn.prepareStatement(sql);
//			
//			//3. 쿼리문 실행
//			System.out.println(memberName + ", " + memberId + ", " + memberPw);
//			pstmt.setString(1, memberName);
//			pstmt.setString(2, memberId);
//			pstmt.setString(3, memberPw);
//			System.out.println(pstmt);
//			int result = pstmt.executeUpdate(); //실행 후 결과 담기
//			
//			//4. 값이 있는지 확인
//			if(result != 0) {
//
//				vo = loginMember(memberId, memberPw);
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
	
}
