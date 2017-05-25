package com.dao;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.acorn.controller.MemberController;
import com.dto.BoardinfoforlistDTO;
import com.dto.BoardpageDTO;

@Repository
public class BoardDAO {

	@Autowired
	private SqlSession session;
	
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	
	
	public BoardpageDTO getboardlist(BoardinfoforlistDTO bi){
		
		BoardpageDTO dto = new BoardpageDTO();
		dto.setTotalcount(session.selectOne("getboardcount"));
		dto.setBinfo(bi);
		
		
		return null;
	}
	
}
