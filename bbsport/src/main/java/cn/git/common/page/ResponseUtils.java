package cn.git.common.page;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

/**
 * 寮傛杩斿洖鍚勭鏍煎紡
 * json
 * xml
 * text
 * @author lx
 *
 */
public class ResponseUtils {

	//鍙戦�佸唴瀹�  
	public static void render(HttpServletResponse response,String contentType,String text){
		response.setContentType(contentType);
		try {
			response.getWriter().write(text);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//鍙戦�佺殑鏄疛SON
	public static void renderJson(HttpServletResponse response,String text){
		render(response, "application/json;charset=UTF-8", text);
	}
	//鍙戦�亁ml
	public static void renderXml(HttpServletResponse response,String text){
		render(response, "text/xml;charset=UTF-8", text);
	}
	//鍙戦�乼ext
	public static void renderText(HttpServletResponse response,String text){
		render(response, "text/plain;charset=UTF-8", text);
	}
	
	
}
