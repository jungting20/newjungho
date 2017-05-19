package com.acorn.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dto.LoginDTO;
import com.dto.MemberDTO;
import com.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	
	
	@RequestMapping(value="loginform",method=RequestMethod.GET)
	public void gologinform(){
		
	}
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public void login(LoginDTO dto,Model model,HttpSession session){
		
		
		model.addAttribute("member",service.login(dto));
		model.addAttribute("LoginDTO",dto);
		
		
	}
	@RequestMapping(value="loginsuccess",method=RequestMethod.GET)
	public void loginsuccess(){
		
		
	}
	@RequestMapping("logout")
	public String logout(HttpSession session){
		session.invalidate();
		
		return "member/loginform";
	}
	@RequestMapping("doattend")
	public String doattend(){
		//course 는 레지스터에있음 조인해서 코스아이디 얻어오고 student_id는 세션에서 얻어오고
		//student_id,course_id,tag_time,course_date
		//jsp 폴더에서 뷰 가져다가 넣어주고 리턴값 그걸로 해주면 끝 
		return null;
	}

}
