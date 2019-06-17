package com.irish.dao;

import com.irish.entity.User;
import com.irish.orm.annotation.ExtDelete;
import com.irish.orm.annotation.ExtInsert;
import com.irish.orm.annotation.ExtParam;
import com.irish.orm.annotation.ExtSelect;
import com.irish.orm.annotation.ExtUpdate;


public interface UserDao {

	@ExtSelect("select * from User where userName=#{userName} and userAge=#{userAge} ")
	User selectUser(@ExtParam("userName") String name, @ExtParam("userAge") Integer userAge);

	@ExtInsert("insert into user(userName,userAge) values(#{userName},#{userAge})")
    int insertUser(@ExtParam("userAge") Integer userAge, @ExtParam("userName") String name);
	
	@ExtDelete("delete from user where userName=#{userName} ")
	void deleteUserByUserName(@ExtParam("userName") String name);
	
	@ExtUpdate("update user set userAge = #{userAge}  where userName = #{userName} ")
	void updateUser(@ExtParam("userAge") Integer userAge, @ExtParam("userName") String name);
}
