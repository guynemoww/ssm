package cn.git.core.controller.admin;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.git.common.page.ResponseUtils;
import cn.git.core.web.Constants;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;


@Controller
public class UploadController {
	@RequestMapping(value = "/upload/uploadPic.do")
	public void uploadPic(@RequestParam(required = false) MultipartFile pic,HttpServletResponse response){
		//扩展名
		String ext = FilenameUtils.getExtension(pic.getOriginalFilename());
		
		//图片名称生成策略
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		//图片名称一部分
		String format = df.format(new Date());
		
		//随机三位数
		Random r = new Random();
		// n 1000   0-999   99
		for(int i=0 ; i<3 ;i++){
			format += r.nextInt(10);
		}
		
		//实例化一个Jersey
		Client client = new Client();
		//保存数据库
		String path = "upload/" + format + "." + ext;
		
		//另一台服务器的请求路径是?
		String url = Constants.IMAGE_URL  + path;
		//设置请求路径
		WebResource resource = client.resource(url);
		
		//发送开始  POST  GET   PUT
		try {
			resource.put(String.class, pic.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//返回二个路径
		JSONObject jo = new JSONObject();
		jo.put("url", url);
		jo.put("path",path);
		
		ResponseUtils.renderJson(response, jo.toString());
	}
}
