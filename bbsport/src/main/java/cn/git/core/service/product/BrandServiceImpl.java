package cn.git.core.service.product;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.common.page.Pagination;
import cn.git.core.bean.product.Brand;
import cn.git.core.dao.product.BrandDao;

/**
 * 閸濅胶澧濇禍瀣
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
		//1:鐠у嘲顫愭い锟�  startRow = (pageNo - 1)*pageSize
		//2:濮ｅ繘銆夐弫锟�
		//3:閹槒顔囪ぐ鏇熸殶
		Pagination  pagination = new Pagination(brand.getPageNo(),brand.getPageSize(),brandDao.getBrandCount(brand));
		//Brand闂嗗棗鎮�
		pagination.setList(brandDao.getBrandListWithPage(brand));
		
		return pagination;
	}

	public void addBrand(Brand brand) {
		brandDao.addBrand(brand);
	}

	@Override
	public void deleteBrandById(Integer id) {
		brandDao.deleteBrandById(id);
	}

	@Override
	public void updateBrand(Brand brand) {
		brandDao.updateBrand(brand);
	}

	@Override
	public Brand getBrandById(Integer id) {
		Brand brand = brandDao.getBrandById(id);
		return brand;
	}
}
