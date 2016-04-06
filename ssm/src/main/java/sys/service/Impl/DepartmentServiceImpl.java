package sys.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sys.dao.BaseDao;
import sys.entity.Department;
import sys.service.DepartmentService;
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
    private BaseDao<Department,Integer> baseDao;
	@Override
	public Department getDepartment(Integer id) {
		// TODO Auto-generated method stub
		return baseDao.get(Department.class, id);
	}
	@Override
	public Department getDepartment2(Integer id) {
		// TODO Auto-generated method stub
		return baseDao.load(Department.class, id);
	}
	@Override
	public Department getDepartment3(Integer id) {
		String hql="select d from Department d where d.id=?";
		return baseDao.get(hql, id);
	}
	@Override
	public List<Department> findBySQL(Integer id) {
		String sql="select *from department  where id=?";
		return baseDao.findBySQL(Department.class, sql, id);
	}
}
