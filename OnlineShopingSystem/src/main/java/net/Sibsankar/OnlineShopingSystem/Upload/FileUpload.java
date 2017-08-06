package net.Sibsankar.OnlineShopingSystem.Upload;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUpload {
	
	private static final String ABSOLUTE_PATH="D:\\STUDY\\work\\Online-ShopingSystem\\OnlineShopingSystem\\src\\main\\webapp\\static\\imeges\\";
    private static String REAL_PATH="";
    private static final Logger loger=LoggerFactory.getLogger(FileUpload.class);
	public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) {
		
		REAL_PATH=request.getSession().getServletContext().getRealPath("/static/imeges/");
		loger.info(REAL_PATH);
        
		if(!new File(ABSOLUTE_PATH).exists()){
			new File(ABSOLUTE_PATH).mkdirs();
		}
		if(!new File(REAL_PATH).exists()){
			new File(REAL_PATH).mkdirs();
		}
		try{
			file.transferTo(new File(REAL_PATH + code + ".jpg"));
			file.transferTo(new File(ABSOLUTE_PATH + code + ".jpg"));
		}catch(IOException ex){
			ex.printStackTrace(); 
			
		}
		
	}

}
