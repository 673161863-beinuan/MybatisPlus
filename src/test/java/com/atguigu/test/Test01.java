package com.atguigu.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import com.atguigu.mp.beans.Employee;
import com.atguigu.mp.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
	
	private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
	private EmployeeMapper employeeMapper = ioc.getBean("employeeMapper",EmployeeMapper.class);

	@Test
	public void select(){
		Employee employee = employeeMapper.selectById(5);
		System.out.println(employee);
	}

	@Test
	public void selectOneById(){
		Employee employee = new Employee();
		//根据多个条件查询，，，但是返回值只能是一条。多条会抛异常
		employee.setId(3);
		employee.setLastName("Black");
		Employee result = employeeMapper.selectOne(employee);
		System.out.println(result);
	}

	@Test
	public void selectBatchById(){

		List<Integer> idList = new ArrayList<>();

		idList.add(1);
		idList.add(2);
		idList.add(3);
		//通过多个id批量查询
		List<Employee> employees = employeeMapper.selectBatchIds(idList);
		for (Employee employee : employees) {
			System.out.println(employee);
		}

	}


	@Test
	public  void testMap(){
		Map<String,Object> map = new HashMap<>();
		//key需要是数据库对应的列名而不是实体类的属性名
		map.put("last_name", "Tom");
		map.put("gender", 1);
		List<Employee> employees = employeeMapper.selectByMap(map);
		for (Employee employee : employees) {
			System.out.println(employee);

		}
	}
	@Test
	public void testMp() throws SQLException {
		DataSource dataSource = ioc.getBean("dataSource",DataSource.class);
		System.out.println(dataSource);
		Connection connection = dataSource.getConnection();
		System.out.println(connection);
		connection.close();

	}
	@Test
	public void testInsert() {
		Employee employee = new Employee();
		employee.setLastName("MP4");
		employee.setEmail("123@qq.com");
		employee.setAge(23);
		employee.setGender(1);
		Integer result = employeeMapper.insert(employee);
		System.out.println("result = "+result);

		Integer id = employee.getId();
		System.out.println("id"+id);

	}

	@Test
	public void updateById(){
		Employee employee = new Employee();
		employee.setId(6);
		employee.setLastName("jack1");
		employee.setGender(0);
		//employee.setAge(12);
		//这个方法会动态判断值是否为空，不会去修改
		//Integer result = employeeMapper.updateById(employee);
		//这个方法不会动态判断值是否为空，没有给的值默认为空，修改为空
		Integer result = employeeMapper.updateAllColumnById(employee);
		System.out.println("result = "+result);

	}

}
