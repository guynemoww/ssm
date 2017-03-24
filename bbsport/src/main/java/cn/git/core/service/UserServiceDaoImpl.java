package cn.git.core.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import cn.git.core.bean.User;
import cn.git.core.dao.UserDao;

@Service
public class UserServiceDaoImpl implements UserServiceDao {
	@Resource
	private UserDao userDao;
	
	public void addUser(User user) {
		try {
			userDao.addUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
