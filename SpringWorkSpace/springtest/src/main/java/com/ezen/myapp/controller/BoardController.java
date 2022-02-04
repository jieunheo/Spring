package com.ezen.myapp.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ezen.myapp.model.BoardDao;
import com.ezen.myapp.model.BoardVo;


/* 컨트롤러로 등록 */
@Controller
public class BoardController {
	
	/* 객체로 생성된 주소를 이곳에 주입 */
	@Autowired
	BoardDao bd;

	@RequestMapping(value="/board/boardWrite.do")
	public String boardWrite() {
		
		/* boardWrite.jsp 페이지로 이동 */
		return "boardWrite";
		
	}
	
	@RequestMapping(value="/board/boardWriteAction.do")
	public String boardWriteAction(@RequestParam("subject") String subject) {
		
		/* boardWriteAction 처리 후 boardList 페이지로 이동 */
		
		//1. boardWriteAction 처리
		//	1-1. 파라미터(매개변수) 받기 -> @RequestParam("subject") String subject
		
		//	1-2. 값을 DB에 입력(처리)
		//bd = new BoardDao(); //@Autowired로 이미 객체 생성
		int exec = bd.insertBoard(subject); //글 추가
		
		//2. redirect: 를 이용하여 sendRedirect 실행
		if(exec != 0) return "redirect:/index.jsp"; //url 외부이동
		else          return "boardWrite";          //url 내부이동
		
		
		
		
	}
	
	@RequestMapping(value="/board/boardList.do")
	public String boardList() {
		
		/* boardList.jsp 페이지로 이동 */
		/* 글목록 뿌려주기 */
		//1. 전체 데이터 가져오기
		//bd = new BoardDao(); //객체 생성
		//ArrayList<BoardVo> alist = bd.selectAllBoard(); //글목록 보기
		
		//2. request에 값 담기
		//request.setAttribute("alist", alist);
		
		//3. 글목록 페이지로 이동 (foward) - url 내부이동
		//rd = request.getRequestDispatcher("/boardList.jsp");
		//rd.forward(request, response);
		
		return "redirect:/index.jsp";
	
	}
	
}
