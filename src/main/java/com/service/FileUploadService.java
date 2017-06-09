package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.FileUploadDAO;
import com.dto.BoardinfoforlistDTO;
import com.dto.BoardpageDTO;
import com.dto.FileUploadDTO;

@Service
public class FileUploadService {

	@Autowired
	FileUploadDAO dao;

	public void fileupload(List<FileUploadDTO> list) throws Exception {

		dao.fileupload(list);

	}

	public BoardpageDTO getfilelist(BoardinfoforlistDTO bi) throws Exception {
		
		return dao.getfilelist(bi);
	}

}
