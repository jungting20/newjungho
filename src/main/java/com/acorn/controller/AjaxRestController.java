package com.acorn.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.acorn.common.UploadUtil;
import com.dto.ArticleCommentDTO;
import com.dto.AttendanceDTO;
import com.dto.MemberDTO;
import com.service.MemberService;

@RestController
@RequestMapping("/ajax/*")
public class AjaxRestController {
	
	@Autowired
	private MemberService service;
	
	@Resource(name="uploadpath")
	private String uploadpath;
	
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
	public void updatemember(@RequestBody MemberDTO dto)throws Exception{
		
		
		service.updatemember(dto);
			
	}
	@RequestMapping("readarticleajax")
	public ResponseEntity<String> readarticleajax(HttpSession session,HttpServletRequest request,HttpServletResponse response)throws Exception{
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-type", "text/html;charset=UTF-8");
		ResponseEntity<String> rs = null;
		HashMap<String, String> map = new HashMap<>();
		MemberDTO dto = (MemberDTO)session.getAttribute("userid");
		String articlecatergory = dto.getArticlecategory();
		if(request.getParameter("category")!=null){
			articlecatergory=request.getParameter("category");
			session.removeAttribute("rss");
		}
		String newscompany = request.getParameter("newscompany");
		
		if(newscompany == null){
			newscompany="중앙일보";
		}
		map.put("newscompany", newscompany);
		map.put("articlecatergory", articlecatergory);
		
		//log.info(service.urlcrawling(map));
		rs = new ResponseEntity<String>(service.urlcrawling(map), header, HttpStatus.OK);
		return rs;
	}
	
	@RequestMapping("readhtmlajax")
	public ResponseEntity<String> readhtml(String link) throws Exception{
		
		log.info("들어오는링크값:"+link);
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-type", "text/html;charset=UTF8");
		ResponseEntity<String> rs = null;
		HashMap<String,String> map = new HashMap<>();
		map.put("link", link);
		
		rs = new ResponseEntity<String>(service.urlcrawling(map),header,HttpStatus.OK);
		return rs;
	}
	@RequestMapping("getcommentajax")
	public ResponseEntity<List<ArticleCommentDTO>> 
	getarticomment(String link) throws Exception{
		
		ResponseEntity<List<ArticleCommentDTO>> rs = null;
		rs = new ResponseEntity<>(service.getarticlecommentlist(link),HttpStatus.OK);
		
		
		return rs;
	}
	@RequestMapping("writecommentajax")
	public void writecommentajax(@RequestBody ArticleCommentDTO dto)
			throws Exception{
		
		service.writecomment(dto);
	}
	@RequestMapping("uploadajax")
	public String uploadajax(MultipartRequest request) throws Exception{
		
		List<MultipartFile> list = request.getFiles("file");
		
		
		
		
		return null;
	}
	

	
	
	
	
}
