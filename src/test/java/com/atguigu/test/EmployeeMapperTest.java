package com.atguigu.test;

import com.atguigu.mp.beans.Employee;
import com.atguigu.mp.mapper.EmployeeMapper;
import com.atguigu.mp.service.EmployeeService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeMapperTest {

    private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
    private EmployeeService employeeService= ioc.getBean("employeeService",EmployeeService.class);
    @Test
    public void testInsert() {
        Employee employee = new Employee();
        employee.setLastName("MP5");
        employee.setEmail("123@qq.com");
        employee.setAge(23);
        employee.setGender(1);
        Integer relust = employeeService.insert(employee);
        System.out.println("relust:" + relust);

    }

    @Test
    public void testInsertAllColumn() {
    }

    @Test
    public void testDeleteById() {
    }

    @Test
    public void testDeleteByMap() {
    }

    @Test
    public void testDelete() {
    }

    @Test
    public void testDeleteBatchIds() {
    }

    @Test
    public void testUpdateById() {
    }

    @Test
    public void testUpdateAllColumnById() {
    }

    @Test
    public void testUpdate() {
    }

    @Test
    public void testUpdateForSet() {
    }

    @Test
    public void testSelectById() {
    }

    @Test
    public void testSelectBatchIds() {
    }

    @Test
    public void testSelectByMap() {
    }

    @Test
    public void testSelectOne() {
    }

    @Test
    public void testSelectCount() {
    }

    @Test
    public void testSelectList() {
    }

    @Test
    public void testSelectMaps() {
    }

    @Test
    public void testSelectObjs() {
    }

    @Test
    public void testSelectPage() {
    }

    @Test
    public void testSelectMapsPage() {
    }

}
