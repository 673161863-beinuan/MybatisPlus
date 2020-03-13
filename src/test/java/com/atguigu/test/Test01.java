package com.atguigu.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
import javax.sql.DataSource;
import com.atguigu.mp.beans.Employee;
import com.atguigu.mp.mapper.EmployeeMapper;
import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
	
	private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
	private EmployeeMapper employeeMapper = ioc.getBean("employeeMapper",EmployeeMapper.class);

	@Test
	public void testOthers(){
		List<Employee> employees = employeeMapper.selectList(
				new EntityWrapper<Employee>()
						.eq("gender", 0)
						//倒序
						//.orderDesc(Arrays.asList("age"))
						//默认正序
						.orderBy("age")
		);
		for (Employee employee : employees) {
			System.out.println(employee);
		}
	}
	@Test
	public void mySelectList(){
		List<Employee> empls = employeeMapper.getEmpls();
		for (Employee empl : empls) {
			System.out.println(empl);
		}

	}
	@Test
	public void testEntityWrapperDelete(){
		EntityWrapper<Employee> wrapper = new EntityWrapper<>();
		wrapper.eq("last_name", "Tom").eq("age", 22);
		Integer reslult = employeeMapper.delete(wrapper);
		System.out.println(reslult);
	}

	@Test
	public void testEntityWrapperUpdate(){
		Employee employee = new Employee();
		employee.setLastName("rose");
		employee.setGender(0);
		employee.setEmail("rose@qq.com");
		EntityWrapper<Employee> wrapper = new EntityWrapper<>();
		wrapper.eq("last_name", "Tom").eq("age", 23);
		Integer result = employeeMapper.update(employee, wrapper);
		System.out.println(result);

	}

	@Test
	public void testEntityWrapper(){

		List<Employee> employees = employeeMapper.selectPage(new Page<Employee>(1, 2), new EntityWrapper<Employee>()
				.between("age", 18, 25)
				.eq("last_name", "Tom")
				.eq("gender", 1)
		);
		for (Employee employee : employees) {
			System.out.println(employee);
		}
	}

	@Test
	public void testOr(){
		//查询名字带有T的，性别是男的或邮箱带有 “ r ”的
		//1.使用EntityWrapper
	/*	List<Employee> employees = employeeMapper.selectList(new EntityWrapper<Employee>()
				.like("last_name", "T")
				.eq("gender", 1)
				.or()
				.like("email", "r")
		);
		for (Employee employee : employees) {
			System.out.println(employee);
		}*/

		List<Employee> lists = employeeMapper.selectPage(new Page<Employee>(1, 2),
				Condition.create()
						.eq("last_name", "T")
						.eq("gender", 1)
						.or()
						.like("email", "r")
		);
		for (Employee list : lists) {
			System.out.println(list);
		}


	}
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
	public void testDelete(){

		Integer result = employeeMapper.deleteById(14);
		System.out.println("result = " + result);
	}

	@Test
	public void testDeleteByMap(){
		Map<String,Object> map = new HashMap<>();
		map.put("last_name", "MP4");
		map.put("email", "123@qq.com");
		Integer result = employeeMapper.deleteByMap(map);
		System.out.println("result = " + result);
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
	public void testDeleteByBatch(){

		List<Integer> idList = new ArrayList<>();
		idList.add(7);
		idList.add(8);
		idList.add(9);
		Integer result = employeeMapper.deleteBatchIds(idList);
		System.out.println("result  = "+result);
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
