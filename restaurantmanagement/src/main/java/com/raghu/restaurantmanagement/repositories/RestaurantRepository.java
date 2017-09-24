package com.raghu.restaurantmanagement.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.raghu.restaurantmanagement.domain.Category;
import com.raghu.restaurantmanagement.domain.Restaurant;

@SuppressWarnings("unused")
public interface RestaurantRepository extends CrudRepository<Restaurant, String> {

	 @Query(value = "SELECT * FROM restaurant WHERE category_id = ?1", nativeQuery = true)
	List<Restaurant> findtByCategoryId(String categoryId);

}
