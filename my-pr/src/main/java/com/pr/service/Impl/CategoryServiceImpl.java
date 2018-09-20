package com.pr.service.Impl;

import java.util.List;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pr.domain.CategoryDTO;
import com.pr.entity.CategoryEntity;
import com.pr.repository.CategoryRepository;
import com.pr.service.CategoryService;
import com.pr.service.utils.ObjectMapperUtils;
import com.pr.service.utils.StringUtils;


@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private ObjectMapperUtils objectMapperUtils;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private StringUtils stringUtils;
	
	@Override
	public void createCategory(CategoryDTO category) {
		category.setCategoryId(stringUtils.generate());
		categoryRepository.save(objectMapperUtils.map(category, CategoryEntity.class));
	}

	@Override
	public List<CategoryDTO> getAll() {
		return objectMapperUtils.mapAll(categoryRepository.findAll(), CategoryDTO.class);
	}

	@Override
	public void updateCategory(CategoryDTO categoryDTO) {
		 categoryRepository.save(objectMapperUtils.map(categoryDTO, CategoryEntity.class));
	}

}
