package com.bootcamp.event.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bootcamp.event.domain.Category;
import com.bootcamp.event.dto.CategoryDto;
import com.bootcamp.event.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {
	private final CategoryRepository categoryRepository;
	
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	public String saveCategory(CategoryDto categoryDto) {
		try {
			Category category = new Category();
			category.setName(categoryDto.getName());
			category.setStatus("1");
			categoryRepository.save(category);
			return "Guardado exitoso!!";
		} catch (Exception e) {
			return "Error!! " + e.getMessage();
		}		
	}
	
	public List<CategoryDto> getAllCategory(){
		List<Category> categoryList = this.categoryRepository.findAll();
		return categoryList.stream()
				.map(c -> CategoryDto.builder()
						.id(c.getId())
						.name(c.getName())
						.build())
				.collect(Collectors.toList());
	}
}
