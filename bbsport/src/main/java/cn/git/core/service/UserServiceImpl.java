package cn.git.core.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;


import cn.git.core.bean.User;
import cn.git.core.dao.UserDao;
@Service
//@Transactional//事务注解
public class UserServiceImpl implements UserServiceDao {
	//在service层使用@Resource 在controller层使用@Autowired
	
	@Resource
	private UserDao userDao;
	
	//@Transactional(readOnly=true)
	public void addUser(User user) {
		try {
			userDao.addUser(user);
			//throw new RuntimeException();//开启事务后 抛出异常 数据不会插入到数据库里
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
