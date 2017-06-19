package com.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.MemberDAO;
import com.dto.ArticleCommentDTO;
import com.dto.AttendanceDTO;
import com.dto.LoginDTO;
import com.dto.MemberDTO;
import com.dto.NewsarticleDTO;

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

	public void updatemember(MemberDTO dto) throws Exception {

		dao.updatemember(dto);
	}

	public String urlcrawling(HashMap<String, String> map) throws Exception {
		StringBuffer sb = new StringBuffer();
		String readurl = "";

		if (map.get("link") == null) {
			// rss주소 불러와주는 메서드
			NewsarticleDTO dto = dao.getrssaddress(map);
			readurl = dto.getNewsrssaddress();
		} else {
			readurl = map.get("link");
		}
		InputStreamReader isr = null;
		BufferedReader bf = null;

		try {
			URL url = new URL(readurl);
			URLConnection urlconn = url.openConnection();
			InputStream is = urlconn.getInputStream();
			isr = new InputStreamReader(is, "UTF-8");
			bf = new BufferedReader(isr);
			String str;
			while ((str = bf.readLine()) != null) {

				sb.append(str + "\n\r");
			}

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (bf != null)
				try {
					bf.close();
				} catch (IOException e) {
				}
			if (isr != null)
				try {
					isr.close();
				} catch (IOException e) {
				}

		}

		return sb.toString();
	}

	public List<ArticleCommentDTO> getarticlecommentlist(String link) throws Exception {

		return dao.getarticlecommentlist(link);
	}

	public void writecomment(ArticleCommentDTO dto) throws Exception {

		dao.writecomment(dto);
	}

	public void updatearticlecategory(MemberDTO dto) throws Exception {

		dao.updatearticlecategory(dto);
	}

	public void joinstudent(MemberDTO dto) throws Exception {

		dao.joinstudent(dto);
	}

	public int checkid(String id) throws Exception {

		return dao.checkid(id);

	}

}
