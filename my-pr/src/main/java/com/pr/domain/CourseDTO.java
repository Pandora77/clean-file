package com.pr.domain;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {
	
	private String courseId;
	private String name;
	private String description;
	private BigDecimal prise;
	private String imageUrl;
	private String category;
	private Date date;

}
