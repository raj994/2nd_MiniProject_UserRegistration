package com.registration.statemaster.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.registration.statemaster.entity.StateMaster;

public interface StateMasterRepository extends JpaRepository<StateMaster, Serializable> {


	List<StateMaster> findByCounrtyId(Integer countryId);

}
