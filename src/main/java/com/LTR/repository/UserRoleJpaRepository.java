package com.LTR.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LTR.entity.UserRole;

@Repository("userRoleJpaRepository")
public interface UserRoleJpaRepository extends JpaRepository<UserRole, Serializable> {
	


}
