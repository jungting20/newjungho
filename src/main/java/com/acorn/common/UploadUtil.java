package com.acorn.common;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.dto.FileUploadDTO;

public class UploadUtil {
	
	
	
	
	public static List<FileUploadDTO> 
	fileupload(List<MultipartFile> list,String uploadpath)throws Exception{
		
		List<FileUploadDTO> infolist = new ArrayList<>();
		for (MultipartFile file : list) {
			UUID uid = UUID.randomUUID();
			String fname = uid.toString()+"_"+file.getOriginalFilename();
			byte[] b = file.getBytes();
			String realuploadpath = mkpath(uploadpath);
			File f = new File(realuploadpath, fname);
			FileCopyUtils.copy(b, f);
			infolist.add(new FileUploadDTO(file.getOriginalFilename()));
		}
		return infolist;
	}
	
	
	public static String mkpath(String uploadpath){
		
		Calendar cal = Calendar.getInstance();
		
		String yearpath = File.separator + cal.get(Calendar.YEAR);
		
		String monthpath = yearpath + File.separator + 
				new DecimalFormat("00").
				format(cal.get(Calendar.MONTH)+1);
		
		String datepath = monthpath + File.separator + 
				new DecimalFormat("00").
				format(cal.get(Calendar.DATE));
		mkdir(uploadpath,yearpath,monthpath,datepath);
		return uploadpath+datepath;
	}
	
	public static void mkdir(String uploadpath,String...paths){
		
		if(new File(uploadpath+paths[paths.length-1]).exists()){
			return;
		}
		
		for(String path : paths){
			
			File f = new File(uploadpath+path);
			
			if(!f.exists()){
				f.mkdir();
			}
			
		}
		
	}
	
}
