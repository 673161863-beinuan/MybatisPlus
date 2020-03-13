package com.atguigu.test;

import com.atguigu.mp.beans.Employee;
import com.atguigu.mp.mapper.EmployeeMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class EmployeeMapperTest {
    private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
    EmployeeMapper employeeMapper = ioc.getBean("employeeMapper", EmployeeMapper.class);



    @Test
    public  void testMyInjector(){
        List<Employee> empls = employeeMapper.getEmpls();
        System.out.println(empls);
    }
    @Test
    public void testPerformanceInterceptor() {

        Employee employee = new Employee(null, "孙悟空", "swk@qqcom", 1, 865);
        employeeMapper.insert(employee);
    }

    @Test
    public void delete() {
        employeeMapper.delete(null);
    }


    @Test
    public void selectPage() {
        // List<Employee> employees = employeeMapper.selectPage(new Page<Employee>(1, 2), null);
        Page<Employee> page = new Page<>(2, 5);
        List<Employee> employees = employeeMapper.selectPage(page, null);
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        System.out.println("当前页" + page.getCurrent());
        System.out.println("总条数" + page.getTotal());
        System.out.println("是否有上一页" + page.hasPrevious());
        System.out.println("是否有下一页" + page.hasNext());
        System.out.println("总页数" + page.getPages());
        //将查询结果封装到page对象里
        page.setRecords(employees);
    }

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
        System.out.println("全表查询" + count);
        int genderCount = employee.selectCount(new EntityWrapper<Employee>().eq("gender", 1));
        System.out.println("性别为男的" + genderCount);
    }

    @Test
    public void selectById() {
        Employee employee = new Employee();
        //Employee result = employee.selectById(6);
        employee.setId(17);
        Employee result = employee.selectById();
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
    public void deleteByMap() {
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
    public void selectMapsPage() {
    }
}