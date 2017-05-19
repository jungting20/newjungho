package com.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import com.dto.MemberDTO;
import com.service.MemberService;

public class LoginformInterCeptor extends HandlerInterceptorAdapter{
	
	
	private static Logger log = LoggerFactory.getLogger(LoginformInterCeptor.class);
	
	@Autowired
	private MemberService service;
	
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		Cookie logincookie = WebUtils.getCookie(request, "logincookie");
		if(logincookie != null){
			log.info("로그인폼 프리핸들러 실행"+"\t"+logincookie.getValue());
			HttpSession session = request.getSession();
			String cookieval=logincookie.getValue();
			log.info("getcookie!");
			MemberDTO member = service.logincheck(cookieval);
			log.info("before login user! success");
			session.setAttribute("login", member);
			response.sendRedirect("/test/member/loginsuccess");
			return false;
		}
		
		
		
		return super.preHandle(request, response, handler);
	}
	
	
	
	
}
