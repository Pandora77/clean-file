package com.pr.service.Impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pr.domain.CourseDTO;
import com.pr.entity.CategoryEntity;
import com.pr.entity.CourseEntity;
import com.pr.repository.CourseRepository;
import com.pr.service.CourseService;
import com.pr.service.cloudinary.CloudinaryService;
import com.pr.service.utils.ObjectMapperUtils;
import com.pr.service.utils.StringUtils;



@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private ObjectMapperUtils modelMapper;
	
	@Autowired
	private StringUtils stringUtils;
	
	@Autowired
	private CloudinaryService cloudinaryService;
		
	@Override
	public void create(CourseDTO course) {
		course.setCourseId(stringUtils.generate(20));
		courseRepository.save(objectMapperUtils.map(course, CourseEntity.class));
	}

	
	@Override
	public void update(CourseDTO course) {
		courseRepository.save(objectMapperUtils.map(course, CourseDTO.class));
	}
	
	@Override
	public CourseDTO findById(String courseId) {
		return objectMapperUtils.map(courseRepository.findByCourseId(courseId), CourseDTO.class);
	}
	
	@Override
	public List<CourseDTO> getAllByCategoryId(String categoryId) {
		CategoryEntity category = categoryRepository.findByCategoryId(categoryId);
		return objectMapperUtils.mapAll(courseRepository.findByCategoryId(categoryId), CategoryEntity.class);
	return null;	
	}


	@Override
	public CourseDTO get(String courseId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void delateCourse(Long id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<CourseDTO> getAll() {
		return objectMapperUtils.mapAll(courseRepository.findAll(), CourseDTO.class);
	}


	@Override
	public void uploadImage(MultipartFile file, String courseId) {
	String imageURL = cloudinaryService.uploadFile(file, "course_name: " + courseRepository.findByCourseId(courseId).getName());
			
			CourseEntity course = courseRepository.findByCourseId(courseId);
			
			if(course == null) {
				throw new CourseNotFoundException(NO_RECORD_FOUND);
			}
			
			course.setImageURL(imageURL);
			courseRepository.save(course);	
		
	}



}


	

}
