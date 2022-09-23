package com.danni.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danni.model.dao.DepartmentMapper;
import com.danni.model.entity.Department;
import com.danni.model.service.DepartmentService;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentMapper departmentMapper;

	@Override
	public Integer add(Department t) {
		return departmentMapper.insertSelective(t);
	}

	@Override
	public Integer delete(int id) {
		return departmentMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Department queryById(int id) {
		return departmentMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Department> queryAll() {
		return departmentMapper.queryAll();
	}

	@Override
	public Integer update(Department t) {
		return departmentMapper.updateByPrimaryKeySelective(t);
	}
}
