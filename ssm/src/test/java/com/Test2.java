package com;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sys.entity.User;
import sys.service.UserService;
/**
 * 主要测试hibernate框架的dao中的方法
 * @author Administrator
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class Test2 {
	@Autowired
	private UserService userService;
	@Autowired
	private DataSource dataSource;

	// 测试数据库连接
	@Test
	public void test1() {
		try {
			System.out.println(dataSource.getConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//测试通过ID删除一条数据
	@Test
	public void test2() {
		userService.delete(50);
	}
	
	//测试批量删除
	@Test
	public void test3() {
		//测试deleteBatch
//		List<User>users=new ArrayList<User>();
//		users.add(userService.getUser(21));
//		users.add(userService.getUser(22));
//		userService.deleteBatch(users);
		
		//测试deleteBatch2
		List<Integer>ids=new ArrayList<Integer>();
		ids.add(30);
		ids.add(44);
		userService.deleteBatch2(ids);
		
	}
	
	//测试execute:执行更新、删除语句
	@Test
	public void test4() {
		//userService.delete2(2);
		User user=userService.getUser(31);
		user.setUsername("eeee");
		userService.update(user);
	}
}
