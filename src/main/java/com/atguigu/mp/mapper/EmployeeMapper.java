package com.atguigu.mp.mapper;

import com.atguigu.mp.beans.Employee;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

public interface EmployeeMapper extends BaseMapper<Employee> {

    public List<Employee> getEmpls();
}
