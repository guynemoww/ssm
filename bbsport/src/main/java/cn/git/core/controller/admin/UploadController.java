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
		//��չ��
		String ext = FilenameUtils.getExtension(pic.getOriginalFilename());
		
		//ͼƬ�������ɲ���
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		//ͼƬ����һ����
		String format = df.format(new Date());
		
		//�����λ��
		Random r = new Random();
		// n 1000   0-999   99
		for(int i=0 ; i<3 ;i++){
			format += r.nextInt(10);
		}
		
		//ʵ����һ��Jersey
		Client client = new Client();
		//�������ݿ�
		String path = "upload/" + format + "." + ext;
		
		//��һ̨������������·����?
		String url = Constants.IMAGE_URL  + path;
		//��������·��
		WebResource resource = client.resource(url);
		
		//���Ϳ�ʼ  POST  GET   PUT
		try {
			resource.put(String.class, pic.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//���ض���·��
		JSONObject jo = new JSONObject();
		jo.put("url", url);
		jo.put("path",path);
		
		ResponseUtils.renderJson(response, jo.toString());
	}
}
