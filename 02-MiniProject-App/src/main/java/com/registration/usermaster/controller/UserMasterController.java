package com.registration.usermaster.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.registration.usermaster.entity.UserMaster;
import com.registration.usermaster.service.IUserMasterService;

@RestController
public class UserMasterController {

	@Autowired
	private IUserMasterService iUserMasterService;
	

	@PostMapping("/registerForm")
	public ResponseEntity<String> registerUserForm(@RequestBody UserMaster um) {
		boolean saveUser = iUserMasterService.saveUser(um);
		String msg="Registration Save Sucessfully";
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
	}

	@GetMapping("/formLogin")
	public String formLogin(String email, String password) {
		String loginDetails = iUserMasterService.loginCheck(email, password);
		
		return null;
	}


}
