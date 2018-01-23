package cn.edu.tsai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.tsai.bean.Department;
import cn.edu.tsai.bean.Msg;
import cn.edu.tsai.service.DepartmentService;

@Controller
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping("/depts")
	@ResponseBody
	public Msg getDepts(){
		
		List<Department> list = departmentService.getDepts();
		return Msg.success().add("depts", list);
	}

}
