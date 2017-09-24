package com.raghu.restaurantmanagement.service;

import java.util.List;

import com.raghu.restaurantmanagement.domain.Category;


public interface CategoryService {

	Category save(Category category);

	Category get(String categoryId);
	
	List<Category> getAllCategory();


	

}
