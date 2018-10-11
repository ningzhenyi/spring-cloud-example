package com.nzy.security.persistence;

import com.nzy.security.domain.SysUser;

public interface SysUserMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(SysUser record);

	int insertSelective(SysUser record);

	SysUser selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(SysUser record);

	int updateByPrimaryKey(SysUser record);

	SysUser findByUserName(String userName);
}