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
import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractEntity.
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)

/**
 * Instantiates a new abstract entity.
 */
@Data
public abstract class AbstractEntity implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The created on. */
	@CreatedDate
	@Column(name="createdon", nullable = false, insertable=true, updatable= false)
	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;
	
	/** The updated on. */
	@LastModifiedDate
	@Column(name="updatedon", insertable=false, updatable= true)
	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedOn;
	
	/** The version. */
	@Version
	private Long version;
}
