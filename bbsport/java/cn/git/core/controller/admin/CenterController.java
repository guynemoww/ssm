package cn.git.core.controller.admin;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 鍚庡彴绠＄悊
 * 娴嬭瘯
 * @author lx
 *
 */
@Controller
@RequestMapping(value = "/control")
public class CenterController {
	
//	//姣忎竴涓猄pringmvc
//	@RequestMapping(value = "/test/springmvc.do")
//	public String test(String name,Date birthday){
//		
//		
//		System.out.println();
//		return "";
//	}

/*	@InitBinder
	public void initBinder(WebDataBinder binder, WebRequest request) {
		//杞崲鏃ユ湡鏍煎紡
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		
	}
	*/
	
	@RequestMapping(value = "/index.do")
	public String index(){
		return "index";
	}
	@RequestMapping(value = "/top.do")
	public String top(){
		return "top";
	}
	@RequestMapping(value = "/main.do")
	public String main(){
		return "main";
	}
	@RequestMapping(value = "/left.do")
	public String left(){
		return "left";
	}
	@RequestMapping(value = "/right.do")
	public String right(){
		return "right";
	}
	

}
