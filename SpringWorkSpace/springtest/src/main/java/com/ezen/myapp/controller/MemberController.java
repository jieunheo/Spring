package com.ezen.myapp.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ezen.myapp.model.MemberDao;
import com.ezen.myapp.model.MemberVo;


/* 
 * 컨트롤러로 등록
 * 없으면 객체 생성이 안됨
 */
@Controller
public class MemberController {
	
	/* 객체로 생성된 주소를 이곳에 주입 */
	@Autowired
	MemberDao md;

	@RequestMapping(value="/member/login.do")
	public String login() {
		
		/* memberLogin.jsp 페이지로 이동 */
		return "memberLogin";
		
	}

	@RequestMapping(value="/member/memberList.do")
	public String memberList(Model model) {
		
		/* 회원 목록 뿌려주기 */
		//1. 전체 데이터 가져오기
		//MemberDao md = new MemberDao();
		ArrayList<MemberVo> alist = md.selectAllMember();
		
		//2. request에 값 담기
		model.addAttribute("alist", alist);
		
		//3. 회원 목록 페이지로 이동 (foward) - url 내부이동
		return "memberList";
		
	}
	
	@RequestMapping(value="/member/loginAction.do")
	public String loginAction(HttpServletRequest request,
							@RequestParam("memberId") String memberId,
							@RequestParam("memberPw") String memberPw) {
		
		/* login 실행 */
		//1. 값을 DB에서 확인(처리)
		MemberVo  login = md.loginMember(memberId, memberPw); //login

		//2. 결과 확인 후 화면 이동
		if(login != null) { //값이 있다면

			//세션에 굽기
			HttpSession session = request.getSession();
			session.setAttribute("login", login);
			
			//url 외부이동
			return "redirect:/index.jsp"; //url 외부이동
			
		} else {            //값이 없다면

			//url 내부이동
			return "memberLogin";
			
		}
		
	}

	@RequestMapping(value="/member/join.do")
	public String join() {
		
		/* memberLogin.jsp 페이지로 이동 */
		return "memberJoin";
		
	}

	@RequestMapping(value="/member/joinAction.do")
	public String joinAction(HttpServletRequest request,
							@RequestParam("memberName") String memberName,
							@RequestParam("memberId") String memberId,
							@RequestParam("memberPw") String memberPw) {
		
		/* join 실행 */
		//1. 값을 DB에서 확인(처리)
		MemberVo  join = md.joinMember(memberName, memberId, memberPw); //login

		//2. 결과 확인 후 화면 이동
		if(join != null) { //값이 있다면

			MemberVo  login = md.loginMember(memberId, memberPw); //login
			
			//세션에 굽기
			HttpSession session = request.getSession();
			session.setAttribute("login", login);
			
			//url 외부이동
			return "redirect:/index.jsp"; //url 외부이동
			
		} else {            //값이 없다면

			//url 내부이동
			return "memberLogin";
			
		}
		
	}
	
}
