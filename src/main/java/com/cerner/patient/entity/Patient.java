package com.cerner.patient.entity;

import java.time.LocalDate;
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

// TODO: Auto-generated Javadoc
/**
 * The Class Patient.
 */
@Entity
@Table(name="patient")

/* (non-Javadoc)
 * @see com.cerner.patient.entity.AbstractEntity#toString()
 */
@Data

/**
 * Instantiates a new patient.
 *
 * @param key the key
 * @param firstName the first name
 * @param lastName the last name
 * @param address the address
 * @param dob the dob
 * @param gender the gender
 * @param mobileNumber the mobile number
 */
@AllArgsConstructor

/**
 * Instantiates a new patient.
 */
@NoArgsConstructor
public class Patient extends AbstractEntity {
	
	/** The key. */
	@Id
	@Column(name = "key", nullable = false)
	@SequenceGenerator(name = "patient_seq", sequenceName = "patient_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "patient_seq")
	private Long key;
	
	/** The first name. */
	@Column(name = "first_name")
	private String firstName;
	
	/** The last name. */
	@Column(name = "last_name")
	private String lastName;
	
	/** The address. */
	@OneToOne(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinColumn(name = "addressid", referencedColumnName = "key")
	private Address address;
	
	/** The dob. */
	private LocalDate dob;
	
	/** The gender. */
	private String gender;
	
	/** The mobile number. */
	@Column(name = "mobile_number")
	private String mobileNumber;
}
