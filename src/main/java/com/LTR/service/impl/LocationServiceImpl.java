package com.LTR.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.LTR.entity.Location;
import com.LTR.repository.LocationJpaRepository;
import com.LTR.service.LocationService;

@Service("locationServiceImpl")
public class LocationServiceImpl implements LocationService {
	
	@Autowired
	@Qualifier("locationJpaRepository")
	private LocationJpaRepository locationJpaRepository;

	@Override
	public List<Location> getAll() {
		return this.locationJpaRepository.findAll();
	}

	@Override
	public Location getOne(int locationId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Location addOne(Location location) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int itpId) {
		// TODO Auto-generated method stub
		
	}

}
