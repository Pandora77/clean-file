package com.pr.entity;

import javax.persistence.Column;

public class CategoryEntity extends BaseEntity{

	@Column(nullable = false, unique = true)
	private String name;
		
	@Column(nullable = false, unique = true)
	private String categoryId;
	
}
