package com.LTR.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.LTR.entity.Platform;


@Repository("platformJpaRepository")
public interface PlatformJpaRepository extends JpaRepository<Platform,Serializable> {
	
	@Query(value = "from Platform where serialPlatform = :serialPlatform")
    public abstract Platform findPlatformBySerialPlatform(@Param("serialPlatform")String serialPlatform);	

}
