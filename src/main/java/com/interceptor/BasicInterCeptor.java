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

public class BasicInterCeptor extends HandlerInterceptorAdapter{
	
	
	private static final Logger log = LoggerFactory.getLogger(BasicInterCeptor.class); 
	
	@Autowired
	private MemberService service;
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info("====================end====================");
		
		
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		log.info("=============start==============");
		log.info("요청url"+"\t"+request.getRequestURI()+"\t"+"method:"+request.getMethod());
		log.info("들어온 파라미터:"+"\t"+request.getQueryString());
		
		log.info("전체적용 프리핸들러 끝");
		return true;
	}
	
	
	
	
}
