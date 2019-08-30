package com.LTR.repository;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.LTR.entity.Platform;
import com.LTR.entity.Silicon;
import com.LTR.entity.User;

@Repository("siliconJpaRepository")
@Transactional
public interface SiliconJpaRepository extends JpaRepository<Silicon,Serializable>  {
	
	public abstract List<Silicon> findByplatform(Platform platform);
				
	@Modifying
	@Query(value = "update Silicon set platform=null,dateDelivered=null,userRequest=null,statusSilicon='AVAILABLE',socket=null, userLastReturned=:user where id=:id")
	public abstract int updateReturnRequest(@Param("id") Long id,@Param("user") User  user);
	
	@Query(value = "from Silicon where userRequest= :user and statusSilicon='ASSIGNED'")
    public abstract List<Silicon> findBySiliconRequestUsers(@Param("user") User  user);
	
	@Modifying
	@Query(value = "update Silicon set platform=:platform,userLastReturned=null,statusSilicon='BUSY',socket=:socket where id=:siliconId")
	public abstract int assignUnit(@Param("platform") Platform platform,@Param("socket") String  socket,@Param("siliconId") Long  siliconId);
	
	@Query(value = "from Silicon where statusSilicon= :statusSilicon and userRequest != null ")
    public abstract List<Silicon> finBystatusSilicon(String statusSilicon);
		
	@Modifying
	@Query(value = "update Silicon set userRequest=:user,statusSilicon='REQUESTED',userLastReturned=null where id=:id")
	public abstract int updateRequestOfSilicon(@Param("user") User user,@Param("id") Long id);
	
	@Modifying
	@Query(value = "update Silicon set userLastReturned=null,dateDelivered=now(),statusSilicon='ASSIGNED',userRequest=:userRequestToAssign where id=:siliconId")
	public abstract int assignSiliconToUser(@Param("userRequestToAssign") User userRequestToAssign,@Param("siliconId") Long siliconId);
	
	
	
			
}
