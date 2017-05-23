package com.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dao.MemberDAO;
import com.dto.AttendanceDTO;
import com.dto.LoginDTO;
import com.dto.MemberDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class MemberService {

	static final Logger LOGGER = LoggerFactory.getLogger(MemberService.class);

	@Autowired
	private MemberDAO dao;

	public MemberDTO login(LoginDTO dto) throws Exception {

		return dao.login(dto);
	}

	public MemberDTO login(String userid) throws Exception {

		return dao.login(userid);
	}

	public void addsessionid(String memberid, String sessionid, String type) throws Exception {

		dao.addsessionid(memberid, sessionid, type);
	}

	public MemberDTO logincheck(String cookieval) throws Exception {

		// 자동로그인을 위한 체크
		return dao.beforelogincheck(cookieval);
	}

	public void doattend(String memberid) throws Exception {

		// 출석체크서비스
		dao.doattend(memberid);
	}

	public List<AttendanceDTO> myattendancelist(String memberid) throws Exception {

		// 내 출석리스트를 뽑는 메서드
		return dao.myattendance(memberid);
	}

	public List<AttendanceDTO> studentattendancelist() throws Exception {

		return dao.studentattendancelist();
	}

	public List<MemberDTO> todayabsence() throws Exception {

		return dao.todayabsence();
	}

	public List<AttendanceDTO> getattendancedate(String student_id) throws Exception {

		return dao.getattendancedate(student_id);
	}

	public int getattendancelate(String student_id) throws Exception {

		return dao.getattendancelate(student_id);
	}

	public void updatemyinfo(MemberDTO dto) throws Exception {

		LOGGER.info("서비스실행됨 \t" + dto.getEmail());

		dao.updatemyinfo(dto);

	}

	public List<MemberDTO> memberlist(String mem) throws Exception {

		return dao.memberlist(mem);
	}

	public void updateconfirmation(String id) throws Exception {

		dao.updateconfirmation(id);

	}

}
