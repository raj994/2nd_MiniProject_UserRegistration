package com.registration.countrymaster.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.registration.countrymaster.entity.CountryMaster;

public interface CountryMasterRepository extends JpaRepository<CountryMaster, Serializable> {

}
