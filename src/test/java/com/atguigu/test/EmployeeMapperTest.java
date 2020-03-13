package com.atguigu.test;

import com.atguigu.mp.beans.Employee;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class EmployeeMapperTest {
    private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void insert() {
        Employee employee = new Employee();
        employee.setLastName("SunWuKong");
        employee.setEmail("swk@qq.com");
        employee.setAge(863);
        employee.setGender(1);
        boolean result = employee.insert();
        System.out.println(result);
    }

    @Test
    public void selectAll() {

        Employee employee = new Employee();
        List<Employee> employees = employee.selectAll();
        for (Employee employee1 : employees) {
            System.out.println(employee1);
        }
    }
    @Test
    public void selectList() {

        Employee employee = new Employee();
        List<Employee> employees = employee.selectList(new EntityWrapper<Employee>().like("last_name", "T"));
        for (Employee employee1 : employees) {
            System.out.println(employee1);
        }
    }

    @Test
    public void selectCount() {

        Employee employee = new Employee();
        //全表查询
        int count = employee.selectCount(null);
        System.out.println("全表查询"+count);
        int genderCount = employee.selectCount(new EntityWrapper<Employee>().eq("gender", 1));
        System.out.println("性别为男的"+genderCount);
    }
    @Test
    public void selectById() {
        Employee employee = new Employee();
        //Employee result = employee.selectById(6);
        employee.setId(17);
        Employee result =  employee.selectById();
        System.out.println(result);
    }
    @Test
    public void deleteById() {
        Employee employee = new Employee();
        //boolean result = employee.deleteById(2);
        employee.setId(3);
        boolean result = employee.deleteById();
        System.out.println(result);
    }

    @Test
    public void insertAllColumn() {
    }



    @Test
    public void deleteByMap() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void deleteBatchIds() {
    }

    @Test
    public void updateById() {
    }

    @Test
    public void updateAllColumnById() {
    }

    @Test
    public void update() {
    }

    @Test
    public void updateForSet() {
    }

    @Test
    public void selectBatchIds() {
    }

    @Test
    public void selectByMap() {
    }

    @Test
    public void selectOne() {
    }

    @Test
    public void selectMaps() {
    }

    @Test
    public void selectObjs() {
    }

    @Test
    public void selectPage() {
    }

    @Test
    public void selectMapsPage() {
    }
}