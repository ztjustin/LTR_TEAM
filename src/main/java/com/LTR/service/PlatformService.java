package com.LTR.service;

import java.util.List;

import com.LTR.entity.Platform;

public interface PlatformService {
	
	public abstract List<Platform> getAll();
	
	public abstract Platform getOne(Long platformId);
	
	public abstract Platform addOne(Platform platform);
	
	public abstract void delete(Long platformId);

	public abstract boolean exists(Long platformId);
	
	public abstract Platform findBySerialPlatform(String serialPlatform);

}
