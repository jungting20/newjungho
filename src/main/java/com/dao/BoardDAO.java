package com.dao;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.acorn.controller.MemberController;
import com.dto.BoardDTO;
import com.dto.BoardinfoforlistDTO;
import com.dto.BoardpageDTO;

@Repository
public class BoardDAO {
//깃허브
	@Autowired
	private SqlSession session;
	
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	
	
	public BoardpageDTO getboardlist(BoardinfoforlistDTO bi) throws Exception{
		
		BoardpageDTO dto = new BoardpageDTO();
		log.info("숫자는 못직나:"+"페이지:"+bi.getPage() + 
				"보여줄개수:"+bi.getPerpagelist() + "스타트페이지"+bi.getStart()+"엔드페이지"+bi.getEnd());
		log.info("갯수몇개?:"+session.selectOne("getboardcount",bi));
		dto.setBinfo(bi);
		dto.setTotalcount(session.selectOne("getboardcount",bi));
		dto.setList(session.selectList("getboardlist", bi));
		log.info("스타트페이지:"+dto.getStartpage());
		
		return dto;
	}
	
	public void addboard(BoardDTO dto)throws Exception{
		
		session.insert("addboard", dto);
	}
	
}
