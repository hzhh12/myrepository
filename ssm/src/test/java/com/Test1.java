package com;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sys.entity.Department;
import sys.entity.Idcard;
import sys.entity.Role;
import sys.entity.User;
import sys.service.DepartmentService;
import sys.service.IdcardService;
import sys.service.RoleService;
import sys.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class Test1 {
	@Autowired
	private UserService userService;
	@Autowired
	private DataSource dataSource;
	@Autowired
	private IdcardService idcardService;
	@Autowired
	private RoleService roleService;

	@Autowired
	private DepartmentService departmentService;
	// 测试数据库连接
	@Test
	public void test() {
		try {
			System.out.println(dataSource.getConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 测试双向主键一对一关联级联删除
	@Test
	public void test1() {
		User user = userService.getUserById(1);
		userService.delete(user);
	}

	// 测试双向主键一对一关联主键是否真的由通过外键关联User的主键id生成，结果显示如User新增，则idcard无法新增
	@Test
	public void test2() {
		Idcard idcard = new Idcard();
		idcard.setIdcardname("123456789033");
		idcardService.save(idcard);
	}

	/**
	 * 测试一对多级联保存 CascadeType.PERSIST级联保存不行，采用hibernate的
	 * 
	 * @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	 */
	@Test
	public void test3() {
		Set<User> users = new HashSet<User>();
		Department department = new Department();
		department.setDepartmentname("人事部");
		department.setUsers(users);
		User user1 = new User();
		user1.setUsername("111");
		user1.setDepartment(department);
		User user2 = new User();
		user2.setUsername("ddd");
		user2.setDepartment(department);
		users.add(user1);
		users.add(user2);
		userService.save(users);
	}

	// 测试一对多级联删除
	@Test
	public void test4() {
		User user = userService.getUserById(3);
		userService.delete(user);
	}

	// 测试多对多级联保存
	@Test
	public void test5() {
		Set<User> users = new HashSet<User>();
		Set<Role> roles = new HashSet<Role>();

		User user1 = new User();
		user1.setUsername("用xx1");
		user1.setRoles(roles);

		User user2 = new User();
		user2.setUsername("xx21");
		user2.setRoles(roles);
		users.add(user1);
		users.add(user2);

		Role role = new Role();
		role.setRolename("yy1");
		role.setUsers(users);
		roles.add(role);
		// roleService.save(roles);
		userService.save(users);
	}

	//一对一查询
	@Test
	public void test6(){
		System.out.println(idcardService.getIdcard(53));
		//System.out.println(userService.getUser(53));
		//System.out.println(userService.getUserByLoad(53));
	}
	
	@Test
	public void test7(){
		//System.out.println(userService.getUser(31));
		//System.out.println(userService.getUserById(31));
		//System.out.println(userService.getUserByLoad(31));
		//System.out.println(departmentService.getDepartment3(2));
		//System.out.println(departmentService.getDepartment2(2));
		System.out.println(departmentService.findBySQL(2));
	}
}
