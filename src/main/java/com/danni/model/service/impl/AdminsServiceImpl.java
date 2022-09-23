package com.danni.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danni.model.dao.AdminsMapper;
import com.danni.model.entity.Admins;
import com.danni.model.service.AdminsService;

@Service
@Transactional
public class AdminsServiceImpl implements AdminsService{

	@Autowired
	private AdminsMapper adminsMapper;
	
	@Override
	public Integer add(Admins t) {
		return adminsMapper.insertSelective(t);
	}

	@Override
	public Integer delete(int id) {
		return adminsMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Admins queryById(int id) {
		return adminsMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Admins> queryAll() {
		return adminsMapper.queryAll();
	}

	@Override
	public Integer update(Admins t) {
		return adminsMapper.updateByPrimaryKeySelective(t);
	}

	@Override
	public Admins login(Admins admins) {
		return adminsMapper.login(admins);
	}
}
