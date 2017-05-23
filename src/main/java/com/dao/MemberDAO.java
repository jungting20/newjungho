package com.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.AttendanceDTO;
import com.dto.LoginDTO;
import com.dto.MemberDTO;

@Repository
public class MemberDAO {
	
	
	private static final Logger log = LoggerFactory.getLogger(MemberDAO.class);
	
	@Autowired
	private SqlSession session;
	
	
	//처음 로그인을 위한 메서드
	public MemberDTO login(LoginDTO dto)throws Exception{
		
		
		return session.selectOne("login",dto);
	}
	
	//수정후 새로운 로그인을 위한 메서드
	public MemberDTO login(String userid)throws Exception{
		
		
		return session.selectOne("login",userid);
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
	
	public List<AttendanceDTO> getattendancedate(String student_id) throws Exception{
		
		
		return session.selectList("getattendancedate",student_id);
	}
	public int getattendancelate(String student_id)throws Exception{
		int attendanceday = session.selectOne("getattendancelate",student_id);
		int attendancelate = (attendanceday*100)/18 ;
		
		return attendancelate ;
	}
	public void updatemyinfo(MemberDTO dto)throws Exception{
		
		session.update("updatemyinfo",dto);
		log.info("dao에서 업데이트 메서드 실행됨"+"\t"+dto.getId());
		
	}
	
	public List<MemberDTO> memberlist(String mem)throws Exception{
		
		HashMap<String, String> map = new HashMap<>();
		map.put("mem", mem);
		
		return session.selectList("memberlist", map);
	}
	
	public void updateconfirmation(String id)throws Exception{
		
		session.update("updateconfirmation", id);
		
	}
	
}
