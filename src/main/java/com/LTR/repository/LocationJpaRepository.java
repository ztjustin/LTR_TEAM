package com.LTR.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.LTR.entity.Location;

@Repository("locationJpaRepository")
@Transactional
public interface LocationJpaRepository extends JpaRepository<Location, Serializable> {

}
