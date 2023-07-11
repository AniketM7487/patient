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

// TODO: Auto-generated Javadoc
/**
 * The Class Address.
 */
@Entity
@Table(name="address")

/* (non-Javadoc)
 * @see com.cerner.patient.entity.AbstractEntity#toString()
 */
@Data

/**
 * Instantiates a new address.
 *
 * @param key the key
 * @param address the address
 * @param city the city
 * @param state the state
 * @param pinCode the pin code
 */
@AllArgsConstructor

/**
 * Instantiates a new address.
 */
@NoArgsConstructor
public class Address extends AbstractEntity {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The key. */
	@Id
	@Column(name = "key", nullable = false)
	@SequenceGenerator(name = "address_seq", sequenceName = "address_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "address_seq")
	private Long key;
	
	/** The address. */
	private String address;
	
	/** The city. */
	private String city;
	
	/** The state. */
	@Column(name = "states")
	private String state;
	
	/** The pin code. */
	@Column(name = "pincode")
	private String pinCode;
}
