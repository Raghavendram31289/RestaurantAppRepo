package com.raghu.restaurantmanagement.service;

import java.util.List;

import com.raghu.restaurantmanagement.domain.Restaurant;


public interface RestaurantService {

	Restaurant save(Restaurant restaurant);

	Restaurant get(String restaurantId);
	
	List<Restaurant> getAllRestaurantByCategoryId(String categoryId);

	/**
	 * @param categoryIdId
	 * @return
	 */


	

}
