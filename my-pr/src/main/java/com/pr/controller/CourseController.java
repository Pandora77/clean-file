package com.pr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pr.domain.CourseDTO;
import com.pr.service.CourseService;


@RestController
@RequestMapping("course")
public class CourseController {
	
	@Autowired
	private CourseService courseEntity;
	
	@PostMapping
	public ResponseEntity<Void> addCourse(@RequestBody CourseDTO course) {
		courseService.create(course);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("/{courseId}")
	public ResponseEntity<Void> updateCourse(@PathVariable("courseId")@RequestBody CourseDTO courseDTO) {
		CourseDTO courseEntity = CourseService.findById(id);
		if(courseEntity != null) {
			
			courseDTO.setId(id);
			courseService.saveCourse(courseDTO);
			
		}
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<CourseDTO>> getCourses() {
		List<CourseDTO> courses = courseService.getAll();
		return new ResponseEntity<List<CourseDTO>>(courses, HttpStatus.OK);
	}
	
	 @DeleteMapping
	 public ResponseEntity<Void> delateCourse(@PathVariable("courseId") Long Id) {
		 CourseDTO courseEntity = CourseService.findById(id);
			if(courseEntity != null) {
				
				courseService.delateCourse(course.getId());
				
			}
	 }
	 @GetMapping("{categoryId}")
	public ResponseEntity<List<CourseDTO>> getCourseByCategory(@PathVariable("categoryId") String categoryId){
		List<CourseDTO> byCategory = courseService.getAllByCategoryId(categoryId);
		return new ResponseEntity<List<CourseDTO>>(byCategory,HttpStatus.OK);
	}
		
	
	@GetMapping("{courseId}")
	public ResponseEntity<CourseDTO> getCourse(@PathVariable("courseId") Long Id) {
		CourseDTO courseDTO = courseService.findById(Id);
		return new ResponseEntity<CourseDTO>(courseDTO, HttpStatus.OK);
	}
	
	@PostMapping("image/{courseId}")
	public ResponseEntity<Void> uploadImage(
			@PathVariable("courseId") String courseId,
			@RequestParam("image") MultipartFile file) {
		
		courseService.uploadImage(file, courseId);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	
	
	

}
