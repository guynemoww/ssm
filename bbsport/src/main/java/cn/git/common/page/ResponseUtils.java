package cn.git.common.page;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

/**
 * 瀵倹顒炴潻鏂挎礀閸氬嫮顫掗弽鐓庣础
 * json
 * xml
 * text
 * @author lx
 *
 */
public class ResponseUtils {

	//閸欐垿锟戒礁鍞寸�癸拷  
	public static void render(HttpServletResponse response,String contentType,String text){
		response.setContentType(contentType);
		try {
			response.getWriter().write(text);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//閸欐垿锟戒胶娈戦弰鐤汼ON
	public static void renderJson(HttpServletResponse response,String text){
		render(response, "application/json;charset=UTF-8", text);
	}
	//閸欐垿锟戒簛ml
	public static void renderXml(HttpServletResponse response,String text){
		render(response, "text/xml;charset=UTF-8", text);
	}
	//閸欐垿锟戒辜ext
	public static void renderText(HttpServletResponse response,String text){
		render(response, "text/plain;charset=UTF-8", text);
	}
	
	
}
