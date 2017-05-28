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
	
	
	public BoardpageDTO getboardlist(BoardinfoforlistDTO bi) throws Exception{
		
		BoardpageDTO dto = new BoardpageDTO();
		log.info("숫자는 못직나:"+bi.getPage() + bi.getPerpagelist() + bi.getStart()+bi.getEnd());
		log.info("갯수몇개?:"+session.selectOne("getboardcount",bi));
		dto.setBinfo(bi);
		dto.setTotalcount(session.selectOne("getboardcount",bi));
		dto.setList(session.selectList("getboardlist", bi));
		
		log.info("스타트페이지:"+dto.getStartpage());
		
		return dto;
	}
	
}
