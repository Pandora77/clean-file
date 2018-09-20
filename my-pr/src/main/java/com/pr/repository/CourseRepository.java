package com.pr.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.pr.entity.CourseEntity;


@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Long>{

	CourseEntity findByCourseId(String courseId);
	
	CourseEntity findAllByCategoryId(String categoryId);
	
	
}
