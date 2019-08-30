package com.LTR.service;

import java.util.List;

import com.LTR.entity.OperatingSystem;

public interface OperatingSystemService {
	
	public abstract List<OperatingSystem> getAll();
	
	public abstract OperatingSystem getOne(int operatingSystemId);
	
	public abstract OperatingSystem addOne(OperatingSystem operatingSystem);
	
	public abstract void delete(int operatingSystemId);

}
