package sys.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sys.dao.UserMapper;
import sys.entity.IdCard;
import sys.entity.User;
import sys.service.UserService;
@Service("userSerivce")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	@Override
	public User getUser(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(id);
	}
	@Override
	public void delete(Integer id) {
		userMapper.deleteByPrimaryKey(id);
		
	}
	@Override
	public int save(User user) {
		return userMapper.insert(user);
	}
	@Override
	public void saveIdcard(IdCard idCard) {
		userMapper.insertIdcard(idCard.getIdCardname());
	}

}
