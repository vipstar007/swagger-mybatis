package com.danni.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danni.model.dao.EmployeeMapper;
import com.danni.model.entity.Employee;
import com.danni.model.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeMapper employeeMapper;

	@Override
	public Integer add(Employee t) {
		return employeeMapper.insertSelective(t);
	}

	@Override
	public Integer delete(int id) {
		return employeeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Employee queryById(int id) {
		return employeeMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Employee> queryAll() {
		return employeeMapper.queryAll();
	}

	@Override
	public Integer update(Employee t) {
		return employeeMapper.updateByPrimaryKeySelective(t);
	}

}
