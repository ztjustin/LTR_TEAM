package com.LTR.service;

import java.util.List;

import com.LTR.entity.UserRole;

public interface UserRoleService {
	
	public abstract List<UserRole> getAll();
	
	public abstract UserRole getOne(int roleId);
	
	public abstract UserRole addOne(UserRole role);
	
	public abstract void delete(int roleId);
	

}
