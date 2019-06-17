package com.irish.dao;

import org.junit.jupiter.api.Test;

import com.irish.entity.User;
import com.irish.service.SqlSession;

public class UserDaoTest {


	@Test
	public void  insertUser() throws Exception {
		 UserDao mapper = SqlSession.getMapper(UserDao.class);
		 int insertUser = mapper.insertUser(18, "tom");
		 System.out.println(insertUser);
	}

	@Test
	public void  selectUser() throws Exception {
		 UserDao mapper = SqlSession.getMapper(UserDao.class);
		 User user = mapper.selectUser("tom", 18);
		 System.out.println("查询结果:   " + user.getUserName() + ", " + user.getUserAge());
	}
	
	@Test
	public void  deleteUserByUserName() throws Exception {
		 UserDao mapper = SqlSession.getMapper(UserDao.class);
		 mapper.deleteUserByUserName("tom");
	}
	
	
	@Test
	public void  updateUser() throws Exception {
		 UserDao mapper = SqlSession.getMapper(UserDao.class);
		 mapper.updateUser(20,"tom");
	}

	
	
}
