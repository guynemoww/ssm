package cn.git.core.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;


import cn.git.core.bean.User;
import cn.git.core.dao.UserDao;
@Service
//@Transactional//����ע��
public class UserServiceImpl implements UserServiceDao {
	//��service��ʹ��@Resource ��controller��ʹ��@Autowired
	
	@Resource
	private UserDao userDao;
	
	//@Transactional(readOnly=true)
	public void addUser(User user) {
		try {
			userDao.addUser(user);
			//throw new RuntimeException();//��������� �׳��쳣 ���ݲ�����뵽���ݿ���
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
