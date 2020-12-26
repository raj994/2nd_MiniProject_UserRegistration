package com.registration.usermaster.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.registration.usermaster.entity.UserMaster;

public interface UserMasterRepository extends JpaRepository<UserMaster, Serializable> {


	UserMaster findByEmailId(String emailId);
	UserMaster findByEmailIdAndPassword(String email, String password);

}
