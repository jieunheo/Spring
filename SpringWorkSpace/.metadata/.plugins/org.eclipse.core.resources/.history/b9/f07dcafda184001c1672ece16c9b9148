package com.ezen.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BoardController {

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
		BoardDao db   = new BoardDao(); //객체 생성
		int      exec = db.insertBoard(subject); //글 추가
		
		//	1-3. 페이지 이동 (sendRedirect)
		if(exec != 0) { response.sendRedirect(pj+"/board/boardList.do"); } //url 외부이동
		else { response.sendRedirect(pj+"/board/boardWrite.do"); } //url 내부이동
		
		//2. redirect: 를 이용하여 sendRedirect 실행
		return "redirect:/board/boardList.do";
		
	}
	
}
