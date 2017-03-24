package cn.git.core.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class PicMultipart {

	@RequestMapping(value = "/brand/toAdd.do")
	public String picToAdd(){
		
		return "brand/add";
	}
	
	@RequestMapping(value = "/upload/uploadPic.do")
	public String uploadPic(@RequestParam MultipartFile pic){
		System.out.println(pic.getOriginalFilename());
		
		return "";
	}
	
	
}












