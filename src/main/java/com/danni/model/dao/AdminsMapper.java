package com.danni.model.dao;

import java.util.List;

import com.danni.model.entity.Admins;

public interface AdminsMapper {
    int deleteByPrimaryKey(Integer aid);

    int insert(Admins record);

    int insertSelective(Admins record);

    Admins selectByPrimaryKey(Integer aid);
    
    List<Admins> queryAll();

    int updateByPrimaryKeySelective(Admins record);

    int updateByPrimaryKey(Admins record);
    
    Admins login(Admins admins);
}