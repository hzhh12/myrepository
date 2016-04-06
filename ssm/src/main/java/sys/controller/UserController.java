package sys.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sys.service.DepartmentService;

@Controller
public class UserController {
	@Autowired
	private DepartmentService departmentService;
	@RequestMapping("/test")
	public String test(@RequestParam(value="id",defaultValue="2")String ids,Map<String, Object>map){
		
		Integer id=Integer.parseInt(ids);
		map.put("department", departmentService.getDepartment3(id));
		return "success";
	}
	

}
