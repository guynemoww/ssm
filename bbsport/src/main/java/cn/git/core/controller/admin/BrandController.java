package cn.git.core.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.git.core.bean.product.Brand;
import cn.git.core.service.product.BrandService;
import cn.itcast.common.page.Pagination;


@Controller
public class BrandController {
	@Autowired
	private BrandService brandService;
	
	//品牌列表页面
	@RequestMapping(value = "/brand/list.do")
	public String list(String name,Integer isDisplay,Integer pageNo,ModelMap model){
		
		//参数
		StringBuilder params = new StringBuilder();
		Brand brand = new Brand();
		//判断传进来的名称是否为Null并且还要判断 是否为空串   blank  ""  "   "   emtpy  ""   "  "
		if(name !=null && !name.equals("")){
			brand.setName(name);
			params.append("name=").append(name);
		}
		//是  不是
		if(null != isDisplay){
			brand.setIsDisplay(isDisplay);
			params.append("&").append("isDisplay=").append(isDisplay);
		}else{
			brand.setIsDisplay(1);
			params.append("&").append("isDisplay=").append(1);
		}
		
		//如果页号为null 或小于1  置为1
		
		//页号
		brand.setPageNo(Pagination.cpn(pageNo));
		
		//每页数
		brand.setPageSize(5);
		//分页对象
		Pagination pagination = brandService.getBrandListWithPage(brand);
		
		//分页展示   /brand/list.do?name=瑜伽树（yogatree）&isDisplay=1&pageNo=2
		
		String url = "/brand/list.do";
		pagination.pageView(url, params.toString());
		
		model.addAttribute("pagination", pagination);//request.setAttribute
		model.addAttribute("name", name);//request.setAttribute
		model.addAttribute("isDisplay", isDisplay);//request.setAttribute
		
		return "brand/list";
	}
	@RequestMapping(value = "/brand/toAdd.do")
	public String toAdd(){
		
		return "brand/add";
	}
	
	//增加一个品牌
	@RequestMapping(value = "/brand/add.do")	
//	public String add(String name,String imgUrl,String description,Integer sort,Integer isDisplay){
//		Brand brand = new Brand(); 
//		brand.setName(name);
//		brand.setImgUrl(imgUrl);
//		brand.setDescription(description);
//		brand.setSort(sort);
//		brand.setIsDisplay(isDisplay);
	public String add(Brand brand){
		
		brandService.addBrand(brand);
		//返回的是一个来自页面的http请求
		return "redirect:/brand/list.do";
	}
}











