package com.cerner.patient.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import lombok.Data;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public abstract class AbstractEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@CreatedDate
	@Column(name="createdon", nullable = false, insertable=true, updatable= false)
	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;
	
	@LastModifiedDate
	@Column(name="updatedon", insertable=false, updatable= true)
	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedOn;
	
	@Version
	private Long version;
}
