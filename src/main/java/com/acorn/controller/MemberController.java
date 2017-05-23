package com.acorn.controller;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.WebUtils;

import com.dto.LoginDTO;
import com.dto.MemberDTO;
import com.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	private final String cookiename = "logincookie";
	
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	
	@RequestMapping(value="loginform",method=RequestMethod.GET)
	public void gologinform(){
		
	}
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public void login(LoginDTO dto,Model model,HttpSession session) throws Exception{
		
		
		model.addAttribute("member",service.login(dto));
		model.addAttribute("LoginDTO",dto);
		
		
	}
	@RequestMapping(value="doattendform",method=RequestMethod.GET)
	public void loginsuccess(){
		//출석체크버튼을 누르기위한 창으로 이동
		
	}
	@RequestMapping("logout")
	public String logout(HttpSession session,HttpServletRequest request,HttpServletResponse response)throws Exception{
		deletecookie(request, response, cookiename);
		log.info("logout!");
		session.invalidate();
		return "member/loginform";
	}
	@RequestMapping("doattend")
	public String doattend(HttpSession session,String logout,HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String target = "redirect:myattendancecheck";
		MemberDTO dto = (MemberDTO)session.getAttribute("userid");
		String memberid = dto.getId();
		service.doattend(memberid);
		if(logout != null){
			
			deletecookie(request, response, cookiename);
			log.info("logout!");
			session.invalidate();
			
			target="member/loginform";
		}
		return target;
	}
	@RequestMapping("myattendancecheck")
	public void myattendancelist(Model m,HttpSession session) throws Exception{
		
		MemberDTO dto = (MemberDTO)session.getAttribute("userid");
		String memberid = dto.getId();
		m.addAttribute("list",service.myattendancelist(memberid));
		log.info("myattendancelist!");
	}
	@RequestMapping("studentattendancelist")
	public void studentattendancelist(Model m) throws Exception{
		
		m.addAttribute("list", service.studentattendancelist());
		
	}
	@RequestMapping("todayabsence")
	public void todayabsence(Model m) throws Exception{
		
		m.addAttribute("list",service.todayabsence());
	}
	
	@RequestMapping(value="myinfo",method=RequestMethod.GET)
	public void myinfo(Model m,HttpSession session) throws Exception{
		
		MemberDTO dto = (MemberDTO)session.getAttribute("userid");
		m.addAttribute("attendancelate",service.getattendancelate(dto.getId()));
		
	}
	
	@RequestMapping(value="myinfo",method=RequestMethod.POST)
	public String infomodify(MemberDTO dto,HttpSession session)throws Exception{
		log.info(dto.getEmail());
		
		service.updatemyinfo(dto);
		session.removeAttribute("userid");
		session.setAttribute("userid", service.login(dto.getId()));
		
		return "redirect:myinfo"; 
	}
	
	@RequestMapping("memberlist")
	public void viewmemberlist(String mem,Model m) throws Exception{
		
		m.addAttribute("list",service.memberlist(mem));
		
	}
	
	public void deletecookie(HttpServletRequest request,HttpServletResponse response,
			String cookiename){
		Cookie logincookie = WebUtils.getCookie(request, cookiename);
		if(logincookie == null){
			return;
		}
		logincookie.setMaxAge(0);
		logincookie.setPath("/");
		response.addCookie(logincookie);
		
	}
	
}
