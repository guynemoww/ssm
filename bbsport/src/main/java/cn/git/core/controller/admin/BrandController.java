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
	
	//Ʒ���б�ҳ��
	@RequestMapping(value = "/brand/list.do")
	public String list(String name,Integer isDisplay,Integer pageNo,ModelMap model){
		
		//����
		StringBuilder params = new StringBuilder();
		Brand brand = new Brand();
		//�жϴ������������Ƿ�ΪNull���һ�Ҫ�ж� �Ƿ�Ϊ�մ�   blank  ""  "   "   emtpy  ""   "  "
		if(name !=null && !name.equals("")){
			brand.setName(name);
			params.append("name=").append(name);
		}
		//��  ����
		if(null != isDisplay){
			brand.setIsDisplay(isDisplay);
			params.append("&").append("isDisplay=").append(isDisplay);
		}else{
			brand.setIsDisplay(1);
			params.append("&").append("isDisplay=").append(1);
		}
		
		//���ҳ��Ϊnull ��С��1  ��Ϊ1
		
		//ҳ��
		brand.setPageNo(Pagination.cpn(pageNo));
		
		//ÿҳ��
		brand.setPageSize(5);
		//��ҳ����
		Pagination pagination = brandService.getBrandListWithPage(brand);
		
		//��ҳչʾ   /brand/list.do?name=�٤����yogatree��&isDisplay=1&pageNo=2
		
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
	
	//����һ��Ʒ��
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
		//���ص���һ������ҳ���http����
		return "redirect:/brand/list.do";
	}
}











