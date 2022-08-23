package com.nt.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import lombok.Data;

@Entity
@Data
@Table(name = "PLAN_CATEGORY")
public class PlanCategory {

	@Column(name = "CATEGORY_ID")
	@Id
	@GeneratedValue
	private Integer categoryId;
	
	@Column(name = "CATEGORY_NAME")
	private String  categoryName;
	
	@Column(name = "ACTIVE_SW")
	private String activeSw;
	
	@Column(name = "CREATDED_BY")
	private String createBy;
	
	@Column(name = "UPDATED_BY")
	private String updateBy;
	
	@Column(name = "CREATED_DATE",updatable =  true)
	@CreationTimestamp
	private LocalDate createDate;
	
	@Column(name = "UPDATED_DATE",insertable = false)
	@UpdateTimestamp
	private LocalDate updateDate;
	
}
