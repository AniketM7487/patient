package com.cerner.patient.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address extends AbstractEntity {
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "key", nullable = false)
	@SequenceGenerator(name = "address_seq", sequenceName = "address_seq", initialValue = 1, allocationSize = 1)
	private Long key;
	private String address;
	private String city;
	@Column(name = "states")
	private String state;
	@Column(name = "pincode")
	private String pinCode;
	public Long getKey() {
		return key;
	}
	public void setKey(Long key) {
		this.key = key;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	
	
}
