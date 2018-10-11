package com.nzy.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nzy.security.domain.SysPermission;
import com.nzy.security.domain.SysUser;
import com.nzy.security.persistence.SysPermissionMapper;
import com.nzy.security.persistence.SysUserMapper;

@Service
public class CustomUserService implements UserDetailsService {

	@Autowired
	private SysUserMapper sysUserMapper;

	@Autowired
	private SysPermissionMapper sysPermissionMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SysUser user = sysUserMapper.findByUserName(username);
		if (user != null) {
			List<SysPermission> permissions = sysPermissionMapper.findByAdminUserId(user.getId());
			List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
			for (SysPermission permission : permissions) {
				if (permission != null && permission.getName() != null) {

					GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getName());
					// 1：此处将权限信息添加到 GrantedAuthority 对象中，在后面进行全权限验证时会使用GrantedAuthority 对象。
					grantedAuthorities.add(grantedAuthority);
				}
			}
			return new User(user.getUserName(), user.getPassword(), grantedAuthorities);
		} else {
			throw new UsernameNotFoundException("admin: " + username + " do not exist!");
		}

	}

}
