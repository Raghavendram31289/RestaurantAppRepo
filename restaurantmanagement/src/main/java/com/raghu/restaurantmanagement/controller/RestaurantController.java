package com.raghu.restaurantmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.raghu.restaurantmanagement.domain.Restaurant;
import com.raghu.restaurantmanagement.service.CategoryService;
import com.raghu.restaurantmanagement.service.RestaurantService;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;

	public void setRestaurantService(RestaurantService restaurantService) {
		this.restaurantService = restaurantService;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant) {
		restaurantService.save(restaurant);
		return new ResponseEntity<Restaurant>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{restaurantId}", method = RequestMethod.GET)
	public ResponseEntity<Restaurant> getRestaurant(@PathVariable String restaurantId) {
		Restaurant restaurant = restaurantService.get(restaurantId);
		if (restaurant == null) {
			return new ResponseEntity<Restaurant>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Restaurant>(restaurant, HttpStatus.OK);
	}

	@RequestMapping(value = "/category/{categoryId}", method = RequestMethod.GET)
	public ResponseEntity<List<Restaurant>> getAllRestaurantByCategoryId(@PathVariable String categoryId) {
		List<Restaurant> restauranList = restaurantService.getAllRestaurantByCategoryId(categoryId);
		if (restauranList.isEmpty()) {
			return new ResponseEntity<List<Restaurant>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Restaurant>>(restauranList, HttpStatus.OK);
	}

}
