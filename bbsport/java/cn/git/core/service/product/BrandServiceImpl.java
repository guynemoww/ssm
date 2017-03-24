package cn.git.core.service.product;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.common.page.Pagination;
import cn.git.core.bean.product.Brand;
import cn.git.core.dao.product.BrandDao;

/**
 * 鍝佺墝浜嬪姟
 * @author lx
 *
 */
@Service
@Transactional
public class BrandServiceImpl implements BrandService{
	
	@Resource
	private BrandDao brandDao;

	@Transactional(readOnly = true)
	public Pagination getBrandListWithPage(Brand brand){
		//1:璧峰椤�  startRow = (pageNo - 1)*pageSize
		//2:姣忛〉鏁�
		//3:鎬昏褰曟暟
		Pagination  pagination = new Pagination(brand.getPageNo(),brand.getPageSize(),brandDao.getBrandCount(brand));
		//Brand闆嗗悎
		pagination.setList(brandDao.getBrandListWithPage(brand));
		
		return pagination;
	}

	public void addBrand(Brand brand) {
		brandDao.addBrand(brand);
	}
}
