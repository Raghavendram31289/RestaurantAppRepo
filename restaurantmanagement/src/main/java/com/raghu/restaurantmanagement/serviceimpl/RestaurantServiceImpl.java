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
import com.raghu.restaurantmanagement.repositories.RestaurantRepository;
import com.raghu.restaurantmanagement.service.RestaurantService;

/**
 * 
 *
 */
@SuppressWarnings("unused")
@Component
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	RestaurantRepository restuarentRepository;

	public Restaurant save(Restaurant restuarent) {
		restuarent =restuarentRepository.save(restuarent);
		return restuarent;
	}

	public Restaurant get(String restuarentId) {
		Restaurant restuarent = restuarentRepository.findOne(restuarentId);
		return restuarent;
	}

	public List<Restaurant> getAllRestaurantByCategoryId(String categoryId) {
		List<Restaurant> restauratList= restuarentRepository.findtByCategoryId(categoryId);
		 return restauratList;
	}

}
