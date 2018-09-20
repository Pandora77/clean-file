package com.pr.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "course")
public class CourseEntity extends BaseEntity{
	
	@Column(unique = true)
	private String courseId;
	
	@Column(nullable = false)
	private String name;
	private String description;
	
	@Column(columnDefinition = "DECIMAL(10,2) DEFAULT '0.00'")
	private BigDecimal prise;
	
	private String imageUrl;
	
	private Date date;
	
	@OneToOne
	@JoinColumn(name = "category_id")
	private CategoryEntity category;
	
	
}
