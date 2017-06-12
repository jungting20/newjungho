package com.acorn.controlleradvice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/error/")
public class ErrorPageController {

	
	@RequestMapping("{code}")
	public String go404(@PathVariable("code") String code,RedirectAttributes rdtt){
		String em = "";
		if(code.equals("404")){
			em = "페이지를 찾을 수 없습니다";
		}else if(code.equals("400")){
			em = "잘못된 요청 입니다";
		}else if(code.equals("500")){
			em = "서버에 오류가 발생";
		}
		rdtt.addAttribute("msg", em);
		return "redirect:../error/errorpage";
	}
	
	@RequestMapping(value="errorpage",method=RequestMethod.GET)
	public void goerrpage(){
		
		
	}
	

	
}
