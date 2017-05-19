package com.dao;

import java.util.HashMap;

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
	
	public void addsessionid(String memberid,String sessionid,String type){
		
		HashMap<String, String> map = new HashMap<>();
		map.put("memberid", memberid);
		map.put("sessionid", sessionid);
		map.put("type", type);
		session.update("updatesessionid", map);
	}
	
	public MemberDTO beforelogincheck(String sessionid){
		
		return session.selectOne("beforelogincheck", sessionid);
	}
	
}
