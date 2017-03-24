package cn.git.core.service.product;

import cn.git.core.bean.product.Brand;
import cn.itcast.common.page.Pagination;

/**
 * 品牌
 * @author lx
 *
 */
public interface BrandService {

	public Pagination getBrandListWithPage(Brand brand);
	
	//添加品牌
	public void addBrand(Brand brand);
}
