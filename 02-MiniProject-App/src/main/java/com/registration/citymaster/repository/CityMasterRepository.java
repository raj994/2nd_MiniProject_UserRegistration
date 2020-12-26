package com.registration.citymaster.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.registration.citymaster.entity.CityMaster;

public interface CityMasterRepository extends JpaRepository<CityMaster, Serializable> {

	List<CityMaster> findByStateId(Integer stateId);

}
