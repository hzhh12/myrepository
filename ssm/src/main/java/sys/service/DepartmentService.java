package sys.service;

import java.util.List;

import sys.entity.Department;

public interface DepartmentService {

	Department getDepartment(Integer id);

	Department getDepartment2(Integer id);

	Department getDepartment3(Integer id);

	List<Department> findBySQL(Integer id);
}
