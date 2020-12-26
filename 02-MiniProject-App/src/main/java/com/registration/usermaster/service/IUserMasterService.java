package com.registration.usermaster.service;

import java.util.Map;

import com.registration.usermaster.entity.UserMaster;


public interface IUserMasterService {

	public Map<Integer, String> findCountries();
	
	public Map <Integer,String> findStates(Integer countryId);
	
	public Map<Integer,String> findCities(Integer stateId);

	public boolean isEmailUnique(String emailId);
	
	public boolean saveUser(UserMaster um);
//	login page operations
	public String loginCheck(String email, String pwd);
//	unlock Account operations
	public boolean isTempPwdValid(String email, String tempPwd);
	
	public boolean unlockAccount(String email, String newPwd);
	
	public String forgotPassword(String email);
}
