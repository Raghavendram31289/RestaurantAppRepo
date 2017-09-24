package com.raghu.restaurantmanagement.repositories;

import org.springframework.data.repository.CrudRepository;

import com.raghu.restaurantmanagement.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, String> {

}
