package com.registration.usermaster.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.registration.citymaster.entity.CityMaster;
import com.registration.countrymaster.entity.CountryMaster;
import com.registration.statemaster.entity.StateMaster;

import lombok.Data;
@Data
@Entity
@Table(name = "USER_MASTER")
public class UserMaster {
	@Id
	@GeneratedValue
	@Column(name = "USER_ID")
	private Integer userId;
	@Column(name = "FIRST_NAME")
	private String fName;
	@Column(name = "LAST_NAME")
	private String lName;
	private String email;
	private String phno;
	private Date dob;
	private String pwd;
	private String accStatus;
	private CountryMaster counMaster;
	private StateMaster stateMaster;
	private CityMaster cityMaster;

}
