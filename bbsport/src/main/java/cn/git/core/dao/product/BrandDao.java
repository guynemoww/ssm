package cn.git.core.dao.product;

import java.util.List;

import cn.git.core.bean.product.Brand;

/**
 * 鍝佺墝
 * @author lx
 *
 */
public interface BrandDao {
	//List闆嗗悎
	public List<Brand> getBrandListWithPage(Brand brand);
	
	//鏌ヨ鎬昏褰曟暟
	public int getBrandCount(Brand brand);
	//娣诲姞鍝佺墝
	public void addBrand(Brand brand);
	//删除一个品牌
	public void deleteBrandById(Integer id);
	//修改
	public void updateBrand(Brand brand);
	//查询
	public Brand getBrandById(Integer id);
}
