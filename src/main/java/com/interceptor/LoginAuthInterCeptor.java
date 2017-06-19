package com.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.FlashMapManager;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.support.RequestContextUtils;

public class LoginAuthInterCeptor extends HandlerInterceptorAdapter{

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
			
		HttpSession session = request.getSession();
		String url = request.getRequestURI();
		String query = request.getQueryString();
		
		if(session.getAttribute("userid") == null){
			FlashMap map = new FlashMap();
			map.put("mesg", "로그인 하세요");
			FlashMapManager fm = RequestContextUtils.getFlashMapManager(request);
			fm.saveOutputFlashMap(map, request, response);
			
			response.sendRedirect("/test/member/loginform");
			return false;
		}
		
		return true;
	}
	
	
	
	
}
