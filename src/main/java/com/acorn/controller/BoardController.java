package com.acorn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dto.BoardDTO;
import com.dto.BoardinfoforlistDTO;
import com.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	
	//연습용
	//연습용쓰리
	
	@Autowired
	private BoardService service;
	
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	
	
	@RequestMapping(value="boardlist",method=RequestMethod.GET)
	public void goboardlist(BoardinfoforlistDTO dto,Model m) throws Exception{
		
		
		
		System.out.println("list 사이즈:"+service.getboardlist(dto).getList().size());
		m.addAttribute("dto", service.getboardlist(dto));
		
		
	}
	@RequestMapping(value="boardwriteform",method=RequestMethod.GET)
	public void boardwriteform(BoardinfoforlistDTO dto,Model m)throws Exception{
		
		
		m.addAttribute("info",dto);
	}
	
	@RequestMapping(value="boardwriteform",method=RequestMethod.POST)
	public String boardwrite(BoardDTO dto)throws Exception{
		
		service.addboard(dto);
		return "redirect:boardlist";
	}
	
	
	
	
}
