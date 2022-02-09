package com.ezen.myapp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/* HandlerInterceptorAdapter -> 스프링 추상클래스 */
public class AuthInterceptor extends HandlerInterceptorAdapter {
	
	//prehandle과 posthandle 메소드를 재정의 해서 사용 가능
	
	@Override //prehandle: 해당 메소드 실행 전 동작
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
							Object handler)
							throws Exception {
		
		HttpSession session = request.getSession();
		
		//로그인 하지 않았을 경우
		if(session.getAttribute("login") == null) {
			
			response.sendRedirect(request.getContextPath()+"/member/login.do");
			return false;
			
		}
		
		return true;
		
	}
	
	@Override //posthandle: 해당 메소드 실행 후 동작
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
						Object handler, ModelAndView modelAndView)
						throws Exception {
		
		
		
	}

}
