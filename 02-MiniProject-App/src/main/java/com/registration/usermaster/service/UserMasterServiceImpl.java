package com.registration.usermaster.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registration.citymaster.entity.CityMaster;
import com.registration.citymaster.repository.CityMasterRepository;
import com.registration.countrymaster.entity.CountryMaster;
import com.registration.countrymaster.repository.CountryMasterRepository;
import com.registration.statemaster.entity.StateMaster;
import com.registration.statemaster.repository.StateMasterRepository;
import com.registration.usermaster.entity.UserMaster;
import com.registration.usermaster.repository.UserMasterRepository;

@Service
public class UserMasterServiceImpl implements IUserMasterService {

	@Autowired
	private CountryMasterRepository countryMasterRepository;

	@Autowired
	private StateMasterRepository stateMasterRepository;

	@Autowired
	private CityMasterRepository cityMasterRepository;

	@Autowired
	private UserMasterRepository userMasterRepository;

	@Override
	public Map<Integer, String> findCountries() {
		List<CountryMaster> countryList = countryMasterRepository.findAll();
		Map<Integer, String> countries = new HashMap<>();
		countryList.forEach(country -> {
			countries.put(country.getCountryId(), country.getCountryName());
		});
		return countries;
	}

	@Override
	public Map<Integer, String> findStates(Integer countryId) {
		Map<Integer, String> states = new HashMap<>();
		List<StateMaster> stateList = stateMasterRepository.findByCounrtyId(countryId);
		stateList.forEach(state -> {
			states.put(state.getStateId(), state.getStateName());
		});
		return states;
	}

	@Override
	public Map<Integer, String> findCities(Integer stateId) {
		Map<Integer, String> cities = new HashMap<>();
		List<CityMaster> cityList = cityMasterRepository.findByStateId(stateId);

		return null;
	}

	@Override
	public boolean isEmailUnique(String emailId) {
		UserMaster userDetails = userMasterRepository.findByEmailId(emailId);
		return userDetails.getUserId() != null;
	}

	@Override
	public boolean saveUser(UserMaster um) {
		um.setPwd(passwordGenerator());
		um.setAccStatus("LOCKED");
		UserMaster userObj = userMasterRepository.save(um);
		return userObj.getUserId() != null;
	}

	private String passwordGenerator() {

		char[] password = new char[5];
		String alphaNumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random rmpwd = new Random();
		for (int i = 0; i < 5; i++) {
			password[i] = alphaNumeric.charAt(rmpwd.nextInt(alphaNumeric.length()));
		}
		System.out.println(password.toString());
		return password.toString();
	}

	@Override
	public String loginCheck(String email, String pwd) {
		UserMaster userDetails = userMasterRepository.findByEmailIdAndPassword(email, pwd);
		if (userDetails != null) {
			if (userDetails.getAccStatus().equals("LOCKED")) {
				return "ACCOUNT_LOCKED";

			} else {
				return "LOGIN_SUCESS";
			}
		}
		return "INVALID_CREDENTIALS";
	}

	@Override
	public boolean isTempPwdValid(String email, String tempPwd) {
		UserMaster userDetails = userMasterRepository.findByEmailIdAndPassword(email, tempPwd);
		return userDetails.getUserId() != null;
	}

	@Override
	public boolean unlockAccount(String email, String newPwd) {
		UserMaster userDetails = userMasterRepository.findByEmailId(email);
		userDetails.setPwd(newPwd);
		userDetails.setAccStatus("UNLOCKED");
		try {
			userMasterRepository.save(userDetails);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public String forgotPassword(String email) {
			UserMaster userDetails = userMasterRepository.findByEmailId(email);
			if(userDetails!=null) {
				userDetails.getPwd();
			}
			return null;
	}

}
