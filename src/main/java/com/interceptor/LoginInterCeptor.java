package com.interceptor;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.FlashMapManager;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.util.WebUtils;

import com.dto.LoginDTO;
import com.dto.MemberDTO;
import com.service.MemberService;

public class LoginInterCeptor extends HandlerInterceptorAdapter{

	
	private static final Logger log = LoggerFactory.getLogger(LoginInterCeptor.class);
	@Autowired
	private MemberService service;
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		String mesg = "ok";
		String redirect = "/member/loginform";
		HttpSession session = request.getSession();
		ModelMap map = modelAndView.getModelMap();
		LoginDTO logindto = (LoginDTO)map.get("LoginDTO");
		MemberDTO member =(MemberDTO)map.get("member");
		if(member != null){
		if(logindto.getUserid().equals(member.getId()) && 
		logindto.getPasswd().equals(member.getPassword())){
			session.setAttribute("userid", member);
			if(logindto.getIsautologin() != null){
				log.info("add cookie");
				Cookie logincookie = new Cookie("logincookie",session.getId());
				service.addsessionid(member.getId(), session.getId(), member.getClassification());
				logincookie.setMaxAge(60*60*24*7);
				logincookie.setPath("/");
				response.addCookie(logincookie);
				
			}
			log.info("login success"+"\t"+member.getId());
			if(member.getClassification().equals("student")){
				if(member.getConfirmation()==0){
					log.info("loginfail 매니저 인증 필요");
					mesg = "승인이 필요합니다";
					redirect="/member/loginform";
				}else{
					
					log.info("student login");
					redirect="/member/doattendform";
				}
			}else if(member.getClassification().equals("manager")){
				log.info("manager login");
				redirect="/member/studentattendancelist";
			}
		}else{
			log.info("fail:check password");
			mesg="비밀번호를 확인하세요";
		}
		}else{
			log.info("fail:check id");
			mesg="아이디를 확인하세요";
		}
		
		FlashMap fsm = new FlashMap();
		fsm.put("mesg", mesg);
		FlashMapManager f = RequestContextUtils.getFlashMapManager(request);
		f.saveOutputFlashMap(fsm, request, response);
		
		modelAndView.setViewName("redirect:"+redirect);
		
		
		
		
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		if(session != null){
			log.info("loginprehandle session invalidate");
			session.invalidate();
		}
		
		
		return true;
	}
	
	
	
	
}
