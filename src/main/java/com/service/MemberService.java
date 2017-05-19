package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dao.MemberDAO;
import com.dto.LoginDTO;
import com.dto.MemberDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Service
public class MemberService {
	
	
	static final Logger LOGGER = LoggerFactory.getLogger(MemberService.class);

	
	@Autowired
	private MemberDAO dao;
	
	public MemberDTO login(LoginDTO dto){
		
		return dao.login(dto);
	}
	
	public void addsessionid(String memberid,String sessionid,String type){
		
		dao.addsessionid(memberid, sessionid, type);
	}
	
	public MemberDTO logincheck(String cookieval){
		
		return dao.beforelogincheck(cookieval);
	}
	

	
	
	
}
