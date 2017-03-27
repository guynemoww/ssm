package cn.git.core.dao.product;

import java.util.List;

import cn.git.core.bean.product.Brand;

/**
 * 品牌
 * @author lx
 *
 */
public interface BrandDao {
	//List集合
	public List<Brand> getBrandListWithPage(Brand brand);
	
	//查询总记录数
	public int getBrandCount(Brand brand);
	//添加品牌
	public void addBrand(Brand brand);
	//ɾ��һ��Ʒ��
	public void deleteBrandById(Integer id);
	//�޸�
	public void updateBrand(Brand brand);
	//��ѯ
	public Brand getBrandById(Integer id);
}
