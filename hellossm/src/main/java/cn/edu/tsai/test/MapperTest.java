package cn.edu.tsai.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.edu.tsai.bean.Department;
import cn.edu.tsai.bean.Employee;
import cn.edu.tsai.dao.DepartmentMapper;
import cn.edu.tsai.dao.EmployeeMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class MapperTest {
	
	@Autowired
	DepartmentMapper departmentMapper;
	
	@Autowired
	EmployeeMapper employeeMapper;
	
	@Autowired
	SqlSession sqlSession;
	
	@Test
	public void testCRUD() {
		/*
		ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
		DepartmentMapper bean = ioc.getBean(DepartmentMapper.class);
		*/
		
		System.out.println(departmentMapper);
		/*		
		departmentMapper.insertSelective(new Department(null, "开发部"));
		departmentMapper.insertSelective(new Department(null, "测试部"));
		*/
		
		//employeeMapper.insertSelective(new Employee(null, "Jerry", "M", "Jerry@tsai.edu.cn", 1));
		
		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		for(int i=1;i<1000;i++) {
			String uid = UUID.randomUUID().toString().substring(0, 5)+i;
			mapper.insertSelective(new Employee(null, uid, "M", uid+"@tsai.edu.cn", 1));
		}
		System.out.println("批量完成");
	}
}
