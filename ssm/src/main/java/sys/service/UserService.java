package sys.service;

import sys.entity.User;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

/**
 * Created by Administrator on 2016/4/2.
 */
public interface UserService {
	// 保存用户
	Serializable save(User user);

	void save(Set<User> users);

	// 通过id查询用户
	User getUser(Integer id);

	User getUserById(Integer id);

	User getUserByLoad(Integer id);
	// 删除
	void delete(User user);

	// 通过ID删除一条记录
	void delete(Integer id);

	// 批量删除
	void deleteBatch(Collection<User> o);

	// 通过id批量删除
	void deleteBatch2(Collection<Integer> ids);
	
	/******测试execute,不常用****/
	void delete2(Integer id);
	void update(User user);
}
