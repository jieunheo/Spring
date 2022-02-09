package com.ezen.myapp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ezen.myapp.model.MemberVo;

/* HandlerInterceptorAdapter -> 스프링 추상클래스 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	//prehandle과 posthandle 메소드를 재정의 해서 사용 가능
	
	@Override //prehandle: 해당 메소드 실행 전 동작
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
							Object handler)
							throws Exception {
		
		
		
		return true;
		
	}
	
	@Override //posthandle: 해당 메소드 실행 후 동작
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
						Object handler, ModelAndView modelAndView)
						throws Exception {
		
		//로그인 값 가져오기
		MemberVo login = (MemberVo)modelAndView.getModel().get("login");
		
		//로그인 할 값이 있다면 세션에 굽기
		if(login != null) { //값이 있다면

			//세션에 굽기
			HttpSession session = request.getSession();
			session.setAttribute("login", login);
			
		}
		
	}

}
