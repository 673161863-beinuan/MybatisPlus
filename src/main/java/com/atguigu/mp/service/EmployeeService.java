package com.atguigu.mp.service;

import com.atguigu.mp.beans.Employee;
import com.atguigu.mp.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    public Integer insert(Employee employee){
        return employeeMapper.insert(employee);

    }
}