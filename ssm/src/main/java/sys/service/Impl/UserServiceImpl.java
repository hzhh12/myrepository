package sys.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sys.dao.BaseDao;
import sys.entity.User;
import sys.service.UserService;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

/**
 * Created by Administrator on 2016/4/2.
 */
@Service("userService")
public class UserServiceImpl implements UserService{
    @Autowired
    private BaseDao<User,Integer> baseDao;
    //保存用户
    public Serializable save(User user) {
        return baseDao.save(user);
    }

    public User getUser(Integer id) {
        String hql="select u from User u where u.id=?";
        return baseDao.get(hql,id);
    }

    public User getUserById(Integer id){
        return baseDao.get(User.class,id);
    }

    public void delete(User user) {
        baseDao.delete(user);
    }

	@Override
	public void save(Set<User> users) {
		// TODO Auto-generated method stub
		 baseDao.save(users);
	}

	//通过ID删除一条记录
	@Override
	public void delete(Integer id) {
		baseDao.delete(User.class, id);
	}

	@Override
	public void deleteBatch(Collection<User> o) {
		baseDao.deleteBatch(o);
		
	}

	@Override
	public void deleteBatch2(Collection<Integer> ids) {
		baseDao.deleteBatch2(User.class, ids);
	}

	@Override
	public void delete2(Integer id) {
		String hql="delete from User u where id=?";
		baseDao.execute(hql, id);
		
	}

	@Override
	public void update(User user) {
		String hql="update User u set u.username=? where id=?";
		baseDao.execute(hql, user.getUsername(),user.getId());
		
	}

	@Override
	public User getUserByLoad(Integer id) {
		// TODO Auto-generated method stub
		return baseDao.load(User.class, id);
	}


	
}
