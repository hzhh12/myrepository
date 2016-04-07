package cn.com.test;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sys.entity.IdCard;
import sys.entity.User;
import sys.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class Test1 {
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

	// 测试单向一对一查询
	@Test
	public void test2() {
		System.out.println(userService.getUser(1));
	}

	// 测试单向一对一级联删除
	@Test
	public void test3() {
		userService.delete(4);
	}
	
	// 测试单向一对一级联删除
	@Test
	public void test4() {
		IdCard idCard=new IdCard("13331");
		userService.saveIdcard(idCard);
		User user=new User();
		user.setUsername("xx");
		user.setPassword("rr");
		user.setIdCard(idCard);
		int id=userService.save(user);
		System.out.println(id);
	}
}
