package com.registration.citymaster.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "CITY_MASTER")
public class CityMaster {
	@Id
	@GeneratedValue
	@Column(name = "CITY_ID")
	private Integer cityId;
	@Column(name = "CITY_NAME")
	private String cityName;
	@Column(name = "STATE_ID")
	private Integer stateId;

}
