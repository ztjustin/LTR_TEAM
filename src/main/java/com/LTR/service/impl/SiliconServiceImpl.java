package com.LTR.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.LTR.entity.Platform;
import com.LTR.entity.Silicon;
import com.LTR.entity.User;
import com.LTR.repository.SiliconJpaRepository;
import com.LTR.service.SiliconService;

@Service("siliconServiceImpl")
public class SiliconServiceImpl implements SiliconService {
	
	@Autowired
	@Qualifier("siliconJpaRepository")
	private SiliconJpaRepository siliconJpaRepository;
	

	@Override
	public List<Silicon> getAll() {
		return siliconJpaRepository.findAll();
	}

	@Override
	public Silicon getOne(Long siliconId) {
		return siliconJpaRepository.getOne(siliconId);
	}

	@Override
	public Silicon addOne(Silicon silicon) {
		return siliconJpaRepository.save(silicon);
	}

	@Override
	public void delete(Long siliconId) {
		siliconJpaRepository.deleteById(siliconId);
		
	}

	@Override
	public boolean exists(Long siliconId) {
		return siliconJpaRepository.existsById(siliconId);
	}

	@Override
	public List<Silicon> findByPlatform(Platform platform) {
		return siliconJpaRepository.findByplatform(platform);
	}

	@Override
	public int returnSilicon(Long id, User currentUserToReturn) {
		return siliconJpaRepository.updateReturnRequest(id, currentUserToReturn);
	}

	@Override
	public List<Silicon> findBySiliconRequestUsers(User userRequest) {
		return siliconJpaRepository.findBySiliconRequestUsers(userRequest);
	}

	@Override
	public int assignSilicon(Platform platform, String socket, Long siliconId) {
		return siliconJpaRepository.assignUnit(platform, socket, siliconId);
	}

	@Override
	public List<Silicon> finbBystatusSilicon(String statusSilicon) {
		return siliconJpaRepository.finBystatusSilicon(statusSilicon);
	}

	@Override
	public int requestSilicon(User user, Long id) {
		return siliconJpaRepository.updateRequestOfSilicon(user, id);
	}

	@Override
	public int assignSiliconToUser(User currentUserToAssignSilicon, Long siliconId) {
		return siliconJpaRepository.assignSiliconToUser(currentUserToAssignSilicon, siliconId);
	}



}
