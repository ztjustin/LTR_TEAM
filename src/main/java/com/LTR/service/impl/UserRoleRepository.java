package com.LTR.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.LTR.entity.UserRole;
import com.LTR.service.UserRoleService;

@Service("userRoleRepository")
public class UserRoleRepository implements UserRoleService {

	@Override
	public List<UserRole> getAll() {
		return null;
	}

	@Override
	public UserRole getOne(int roleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserRole addOne(UserRole role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int roleId) {
		// TODO Auto-generated method stub
		
	}
	

}
