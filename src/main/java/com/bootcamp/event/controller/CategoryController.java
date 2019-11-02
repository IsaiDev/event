package com.bootcamp.event.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.event.dto.CategoryDto;
import com.bootcamp.event.service.CategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
	
	private final CategoryService categoryService;
	
	@PostMapping
	public String saveCategory(@RequestBody @Valid CategoryDto categoryDto) {
		return this.categoryService.saveCategory(categoryDto);
	}	

	@GetMapping
	public List<CategoryDto> getAllCategory(){
		return this.categoryService.getAllCategory();
	}

}
