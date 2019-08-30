package com.LTR.service;

import java.util.List;

import com.LTR.entity.Location;

public interface LocationService {
	
	public abstract List<Location> getAll();
	
	public abstract Location getOne(int locationId);
	
	public abstract Location addOne(Location location);
	
	public abstract void delete(int itpId);

}
