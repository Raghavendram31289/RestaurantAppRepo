package com.raghu.restaurantmanagement.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.raghu.restaurantmanagement.domain.Category;
import com.raghu.restaurantmanagement.domain.Restaurant;
import com.raghu.restaurantmanagement.service.RestaurantService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class RestaurantControllerTest {

	@Autowired
	private RestaurantService restaurantService;
	private RestaurantController objectUnderTest;
	private Category category;
	private Restaurant restaurant;

	@Before
	public void setup() {
		objectUnderTest = new RestaurantController();
		objectUnderTest.setRestaurantService(restaurantService);
		category = new Category();
		category.setCategoryId("veg123");
		category.setCategoryName("veg");
		restaurant = new Restaurant();
		restaurant.setRestaurantId("shantsagar123");
		restaurant.setRestaurantName("shanthisagar");
		restaurant.setCategory(category);
		restaurant.setAddress("vijayanagr");
	}

	@Test
	public void testCreateRestaurant() {

		Mockito.when(restaurantService.save(restaurant)).thenReturn(restaurant);
		ResponseEntity<Restaurant> responseEntity = objectUnderTest.createRestaurant(restaurant);
		assertEquals(responseEntity.getStatusCodeValue(), 201);
	}
	@Test
	public void testGetRestaurant() {
		Mockito.when(restaurantService.get("shantsagar123")).thenReturn(restaurant);
		ResponseEntity<Restaurant> responseEntity = objectUnderTest.getRestaurant("shantsagar123");
		assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
		equals(responseEntity.getBody().equals(restaurant));
	}
	
	@Test
	public void testNotFoundRestaurant() {
		Mockito.when(restaurantService.get("shantsagar123")).thenReturn(null);
		ResponseEntity<Restaurant> responseEntity = objectUnderTest.getRestaurant("shantsagar123");
		assertEquals(responseEntity.getStatusCode(), HttpStatus.NOT_FOUND);
	}

	@Test
	public void testGetAllRestaurantByCategoryId() {
		List<Restaurant> restauranList=new ArrayList<Restaurant>();
		restauranList.add(restaurant);
		Mockito.when(restaurantService.getAllRestaurantByCategoryId("veg123")).thenReturn(restauranList);
		ResponseEntity<List<Restaurant>> responseEntity = objectUnderTest.getAllRestaurantByCategoryId("veg123");
		assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
		equals(responseEntity.getBody().get(0).getCategory().equals(category));
		equals(responseEntity.getBody().get(0).equals(restaurant));
	}
	
	@Test
	public void testEmptyRestaurantByCategoryId() {
		List<Restaurant> restauranList=new ArrayList<Restaurant>();
		Mockito.when(restaurantService.getAllRestaurantByCategoryId("veg123")).thenReturn(restauranList);
		ResponseEntity<List<Restaurant>> responseEntity = objectUnderTest.getAllRestaurantByCategoryId("veg123");
		assertEquals(responseEntity.getStatusCode(), HttpStatus.NOT_FOUND);
	}

	@Configuration
	static class RestaurantControllerTestContextConfiguration {
		@Bean
		public RestaurantService restaurantService() {
			return Mockito.mock(RestaurantService.class);
		}
	}

}
