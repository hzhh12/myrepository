package sys.service.Impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sys.dao.BaseDao;
import sys.entity.Role;
import sys.service.RoleService;
@Service("roleService")
public class RoleServiceImpl implements RoleService{
	@Autowired
    private BaseDao<Role,Integer> baseDao;
	@Override
	public void save(Set<Role> roles) {
		baseDao.save(roles);
		
	}

}
