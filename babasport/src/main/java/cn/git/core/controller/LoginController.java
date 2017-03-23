package cn.git.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LoginController {

	@RequestMapping(value = "/login.do")
	public String login(String username){
		System.out.println(username);
		return "";
	}
	
}
