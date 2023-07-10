package com.cerner.patient.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="patient")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient extends AbstractEntity {
	
	@Id
	@Column(name = "key", nullable = false)
	@SequenceGenerator(name = "patient_seq", sequenceName = "patient_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "patient_seq")
	private Long key;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@OneToOne(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinColumn(name = "addressid", referencedColumnName = "key")
	private Address address;
	private LocalDate dob;
	private String gender;
	@Column(name = "mobile_number")
	private String mobileNumber;
}
