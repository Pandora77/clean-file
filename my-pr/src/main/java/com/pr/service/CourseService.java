package com.pr.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import com.pr.domain.CourseDTO;

public interface CourseService {
	
	void create(CourseDTO course);
	
	CourseDTO findById(String courseId);
	
	CourseDTO get(String courseId);
	
	void delateCourse(Long id);

	List<CourseDTO> getAll();

	void uploadImage(MultipartFile file, String courseId);

	void update(CourseDTO course);

	List<CourseDTO> getAllByCategoryId(String categoryId);

}
