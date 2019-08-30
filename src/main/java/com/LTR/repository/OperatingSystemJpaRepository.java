package com.LTR.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LTR.entity.OperatingSystem;

@Repository("operatingSystemJpaRepository")
public interface OperatingSystemJpaRepository extends JpaRepository<OperatingSystem, Serializable> {
	

}
