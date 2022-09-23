package com.danni.model.service;

import org.springframework.stereotype.Service;

import com.danni.model.entity.Admins;

@Service
public interface AdminsService extends BaseService<Admins>{
	public abstract Admins login(Admins admins);
}
