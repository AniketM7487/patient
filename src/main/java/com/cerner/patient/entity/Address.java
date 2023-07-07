package com.cerner.patient.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="address")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address extends AbstractEntity {
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "key", nullable = false)
	@SequenceGenerator(name = "address_seq", sequenceName = "address_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "address_seq")
	private Long key;
	private String address;
	private String city;
	@Column(name = "states")
	private String state;
	@Column(name = "pincode")
	private String pinCode;
}
