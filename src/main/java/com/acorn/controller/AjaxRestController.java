package com.acorn.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dto.AttendanceDTO;
import com.dto.MemberDTO;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.service.MemberService;

@RestController
@RequestMapping("/ajax/*")
public class AjaxRestController {
	
	@Autowired
	private MemberService service;
	
	private static final Logger log = LoggerFactory.getLogger(AjaxRestController.class);
	
	
	@RequestMapping("getattendanceday")
	public List<AttendanceDTO> getattendanceday(HttpSession session) throws Exception{
		//출석 날짜 구하기
		MemberDTO dto = (MemberDTO)session.getAttribute("userid");
		log.info("날짜뽑아오기 실행됨");
		return service.getattendancedate(dto.getId());
	}
	@RequestMapping("updateconfirmationajax/{id}")
	public void updateconfirmationajax(@PathVariable("id") String id) throws Exception{
		
		service.updateconfirmation(id);
		
		
	}
	@RequestMapping("updatememberajax")
	public void updatemember(@RequestBody MemberDTO dto){
		log.info(dto.getEmail());
		
		
	}
	
	
	
}
