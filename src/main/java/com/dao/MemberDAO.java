package com.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.AttendanceDTO;
import com.dto.LoginDTO;
import com.dto.MemberDTO;

@Repository
public class MemberDAO {
	
	
	@Autowired
	private SqlSession session;
	
	
	public MemberDTO login(LoginDTO dto)throws Exception{
		
		
		return session.selectOne("login",dto);
	}
	
	public void addsessionid(String memberid,String sessionid,String type)throws Exception
	{
		
		HashMap<String, String> map = new HashMap<>();
		map.put("memberid", memberid);
		map.put("sessionid", sessionid);
		map.put("type", type);
		session.update("updatesessionid", map);
	}
	
	public MemberDTO beforelogincheck(String sessionid)throws Exception{
		
		return session.selectOne("beforelogincheck", sessionid);
	}
	
	public void doattend(String memberid) throws Exception{
		
		session.insert("doattend", memberid);
	}
	
	public List<AttendanceDTO> myattendance(String memberid)throws Exception{
		
		return session.selectList("myattendancelist", memberid);
	}
	
	public List<AttendanceDTO> studentattendancelist()throws Exception{
		
		
		return session.selectList("studentattendancelist");
	}
	public List<MemberDTO> todayabsence()throws Exception{
		
		return session.selectList("todayabsence");
	}
}
