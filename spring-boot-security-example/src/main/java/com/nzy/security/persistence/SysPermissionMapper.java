package com.nzy.security.persistence;

import java.util.List;

import com.nzy.security.domain.SysPermission;

public interface SysPermissionMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(SysPermission record);

    int insertSelective(SysPermission record);

    SysPermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysPermission record);

    int updateByPrimaryKey(SysPermission record);
    
    public List<SysPermission> findAll();
    
    public List<SysPermission> findByAdminUserId(int userId);
}