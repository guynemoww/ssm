package cn.git.core.service.product;

import cn.git.core.bean.product.Brand;
import cn.itcast.common.page.Pagination;

/**
 * 鍝佺墝
 * @author lx
 *
 */
public interface BrandService {

	public Pagination getBrandListWithPage(Brand brand);
	
	//娣诲姞鍝佺墝
	public void addBrand(Brand brand);
	
	//删除一个品牌
	public void deleteBrandById(Integer id);
	//修改
	public void updateBrand(Brand brand);
	//查询
	public Brand getBrandById(Integer id);
}
