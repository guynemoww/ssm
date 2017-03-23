package cn.git.core.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.git.common.test.SpringJUnitTest;
import cn.git.core.bean.User;
import cn.git.core.service.UserServiceDaoImpl;


public class UserServiceImplTest extends SpringJUnitTest{
	@Autowired
	private UserServiceDaoImpl userServiceDaoImpl;
	@Test
	public void testAddUser() {
		User user = new User();
		user.setUsername("王维");
		user.setAddress("成都市成华区");
		userServiceDaoImpl.addUser(user);
		
	}

}









