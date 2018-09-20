package com.pr.service;

import java.util.List;

import com.pr.domain.CategoryDTO;

public interface CategoryService {

	void createCategory(CategoryDTO category);
	
	List<CategoryDTO> getAll();
	
	void updateCategory(CategoryDTO categoryDTO);
}
