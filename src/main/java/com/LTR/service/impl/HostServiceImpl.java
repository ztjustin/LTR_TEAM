package com.LTR.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.LTR.entity.Host;
import com.LTR.repository.HostJpaRepository;
import com.LTR.service.HostService;

@Service("hostServiceImpl")
public class HostServiceImpl implements HostService {
	
	@Autowired
	@Qualifier("hostJpaRepository")
	private HostJpaRepository hostJpaRepository;
	
	@Override
	public List<Host> getAll() {
		return hostJpaRepository.findAll();
	}

	@Override
	public Host getOne(Long hostId) {
		return hostJpaRepository.getOne(hostId);
	}

	@Override
	public Host addOne(Host host) {
		return hostJpaRepository.save(host);
	}

	@Override
	public void delete(Long hostId) {
		hostJpaRepository.deleteById(hostId);
		
	}
	
	

}
