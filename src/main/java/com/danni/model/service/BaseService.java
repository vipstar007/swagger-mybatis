package com.danni.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface BaseService<T> {

	Integer add(T t);

	Integer delete(int id);

	T queryById(int id);

	List<T> queryAll();

	Integer update(T t);
}
