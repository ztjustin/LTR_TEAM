package com.LTR.service;

import java.util.List;

import com.LTR.entity.Platform;
import com.LTR.entity.Silicon;
import com.LTR.entity.User;

public interface SiliconService {
	
	public abstract  List<Silicon> getAll();
		
	public abstract Silicon getOne(Long siliconId);
	
	public abstract List<Silicon> findByPlatform(Platform platform);
	
	public abstract List<Silicon> findBySiliconRequestUsers(User userRequest);
	
	public abstract List<Silicon> finbBystatusSilicon(String statusSilicon);
	
	public abstract Silicon addOne(Silicon Silicon);
	
	public abstract int returnSilicon(Long id,User currentUserToReturn);
	
	public abstract int assignSiliconToUser(User currentUserToAssign,Long siliconId);
	
	public abstract int requestSilicon(User user,Long id);
	
	public abstract int assignSilicon(Platform platform,String socket,Long siliconId);
	
	public abstract void delete(Long siliconId);
	
	public abstract boolean exists(Long siliconId);

}
