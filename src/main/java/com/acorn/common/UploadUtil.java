package com.acorn.common;

import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.http.MediaType;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.MimeType;
import org.springframework.web.multipart.MultipartFile;

import com.dto.FileUploadDTO;

public class UploadUtil {
	
	private static HashMap<String, MediaType> map; 
	

	static {
		map = new HashMap<>();
		map.put("PNG", MediaType.IMAGE_PNG);
		map.put("GIF", MediaType.IMAGE_GIF);
		map.put("JPEG", MediaType.IMAGE_JPEG);
		map.put("JPG", MediaType.IMAGE_JPEG);
		
	}
	public static  MediaType getmediatype(String type) {
		System.out.println("들어온타입값:"+type);
		System.out.println("미디아타입?"+map.get(type.toUpperCase()));
		return map.get(type.toUpperCase());
	}
	
	
	public static void setMap(HashMap<String, MediaType> map) {
		UploadUtil.map = map;
	}
	
	public static List<FileUploadDTO> 
	fileupload(List<MultipartFile> list,String uploadpath)throws Exception{
		
		List<FileUploadDTO> infolist = new ArrayList<>();
		for (MultipartFile file : list) {
			UUID uid = UUID.randomUUID();
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String today = sdf.format(cal.getTime());
			String fname = uid.toString()+"_"+file.getOriginalFilename();
			byte[] b = file.getBytes();
			String realuploadpath = mkpath(uploadpath);
			File f = new File(realuploadpath, fname);
			FileCopyUtils.copy(b, f);
			infolist.add(new FileUploadDTO(file.getOriginalFilename(),
					realuploadpath+File.separator+fname,fname,today));
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
