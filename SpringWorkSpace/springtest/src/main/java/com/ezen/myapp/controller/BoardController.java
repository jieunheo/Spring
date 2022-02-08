package com.ezen.myapp.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		int exec = bd.insertBoard(subject); //글 추가
		
		//2. redirect: 를 이용하여 sendRedirect 실행
		if(exec != 0) return "redirect:/index.jsp"; //url 외부이동
		else          return "boardWrite";          //url 내부이동
		
	}
	
	@RequestMapping(value="/board/boardList.do")
	public String boardList(Model model) {
		
		/* boardList.jsp 페이지로 이동 */
		
		/* 글목록 뿌려주기 */
		//1. 전체 데이터 가져오기
		//bd = new BoardDao(); //@Autowired로 이미 객체 생성
		ArrayList<BoardVo> alist = bd.selectAllBoard(); //글목록 보기
		
		//2. request에 값 담기
		model.addAttribute("alist", alist);
		
		//3. 글목록 페이지로 이동 (foward) - url 내부이동
		return "boardList";
	
	}
	
	@RequestMapping(value="/board/boardContents.do")
	public String boardContents(@RequestParam("bidx") String bidx, Model model) {
		
		/* boardContents.jsp 페이지로 이동 */
		/* 글내용 뿌려주기 */
		//1. 값 받기
		//String bidx = request.getParameter("bidx");
		System.out.println(bidx);
		
		//2. 데이터 가져오기
		//bd = new BoardDao(); //@Autowired로 이미 객체 생성
		BoardVo  vo = bd.selectOneBoard(bidx); //글 보기
		
		//3. 결과 확인 후 화면 이동
		if(vo != null) { //값이 비어있지 않으면
			
			//request에 값 담기
			model.addAttribute("vo", vo);
			
			//3. 글목록 페이지로 이동 (foward) - url 내부이동
			return "boardContents";
			
		} else {         //값이 비어있으면
			
			//글목록 페이지로 이동 (foward) - url 내부이동
			return "boardList";
			
		}

	}
	
//	@RequestMapping(value="/board/boardDelete.do")
//	public String boardDelete(@RequestParam("bidx") String bidx) {
//		
//		/* 글 삭제 */
//		//1. 값 받기
//		//String bidx = request.getParameter("bidx");
//		System.out.println("bidx: "+bidx);
//		
//		//2. 데이터 가져오기
//		//bd = new BoardDao(); //@Autowired로 이미 객체 생성
//		
//		//3. 결과에 따른 화면 이동
//		if(bd.deleteBoard(bidx)) {
//			
//			//삭제 되었으면
//			return "boardList";
//			
//		} else {
//			
//			//삭제되지 않았으면
//			return "redirect:/index.jsp";
//			
//		}
//		
//	}
	
}
