package sys.service;

import sys.entity.IdCard;
import sys.entity.User;

public interface UserService {
	//通过id查询单向一对一
	User getUser(Integer id);
	//删除
	void delete(Integer id);
	//保存
	int save(User user);
	
	void saveIdcard(IdCard idCard);
}
