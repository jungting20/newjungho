package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.acorn.controller.MemberController;
import com.dto.BoardinfoforlistDTO;
import com.dto.BoardpageDTO;
import com.dto.FileUploadDTO;

@Repository
public class FileUploadDAO {
		
	@Autowired
	SqlSession session;
	
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	
	
	public void fileupload(List<FileUploadDTO> list)throws Exception{
		
		
		session.insert("fileupload",list);
		
	}
	
	public BoardpageDTO getfilelist(BoardinfoforlistDTO bi)throws Exception{
		
		BoardpageDTO dto = new BoardpageDTO();
		log.info("파일카운트:"+session.selectOne("getfilecount")+bi.getPerpagelist());
		dto.setBinfo(bi);
		dto.setTotalcount(session.selectOne("getfilecount"));
		dto.setFlist(session.selectList("getfilelist", bi));
		log.info("뭐가나오지:"+session.selectList("getfilelist", bi).size());
		return dto;
	}
	
	
}
