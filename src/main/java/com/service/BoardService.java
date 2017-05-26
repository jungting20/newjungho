package com.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acorn.controller.MemberController;
import com.dao.BoardDAO;
import com.dto.BoardinfoforlistDTO;
import com.dto.BoardpageDTO;

@Service
public class BoardService {

	@Autowired
	private BoardDAO dao;

	private static final Logger log = LoggerFactory.getLogger(MemberController.class);

	public BoardpageDTO getboardlist(BoardinfoforlistDTO bi) throws Exception {

		
		return dao.getboardlist(bi);

	}
}