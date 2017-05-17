package com.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.LoginDTO;
import com.dto.MemberDTO;

@Repository
public class MemberDAO {
	
	
	@Autowired
	private SqlSession session;
	
	
	public MemberDTO login(LoginDTO dto){
		
		
		return session.selectOne("login",dto);
	}
	
}
