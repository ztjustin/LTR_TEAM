package com.LTR.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LTR.entity.Host;

@Repository("hostJpaRepository")
public interface HostJpaRepository  extends JpaRepository<Host, Serializable>{
	

}
