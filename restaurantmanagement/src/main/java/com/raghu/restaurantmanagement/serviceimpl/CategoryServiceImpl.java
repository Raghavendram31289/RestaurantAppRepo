/**
 * 
 */
package com.raghu.restaurantmanagement.serviceimpl;

import java.security.SecureRandom;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.raghu.restaurantmanagement.domain.Category;
import com.raghu.restaurantmanagement.domain.Restaurant;
import com.raghu.restaurantmanagement.repositories.CategoryRepository;
import com.raghu.restaurantmanagement.repositories.RestaurantRepository;
import com.raghu.restaurantmanagement.service.CategoryService;
import com.raghu.restaurantmanagement.service.RestaurantService;


@SuppressWarnings("unused")
@Component
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;


	public Category save(Category category) {
		category=categoryRepository.save(category);
		return category;
	}

	public Category get(String categoryId) {
		return categoryRepository.findOne(categoryId);
	}

	public List<Category> getAllCategory() {
		return (List<Category>) categoryRepository.findAll();
	}

}
