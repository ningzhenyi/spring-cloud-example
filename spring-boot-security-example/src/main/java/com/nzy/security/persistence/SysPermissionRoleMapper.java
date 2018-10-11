package com.nzy.security.persistence;

import com.nzy.security.domain.SysPermissionRole;

public interface SysPermissionRoleMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(SysPermissionRole record);

    int insertSelective(SysPermissionRole record);

    SysPermissionRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysPermissionRole record);

    int updateByPrimaryKey(SysPermissionRole record);
}