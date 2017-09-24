/**
 * 
 */
package com.raghu.restaurantmanagement.serviceimpl;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.raghu.restaurantmanagement.domain.Category;
import com.raghu.restaurantmanagement.domain.Restaurant;
import com.raghu.restaurantmanagement.repositories.RestaurantRepository;
import com.raghu.restaurantmanagement.service.RestaurantService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class RestaurantServiceImplTest {

	@Autowired
	private RestaurantRepository restaurantRepository;
	@Autowired
	private RestaurantService objectUnderTest;
	private Category category;
	private Restaurant restaurant;
	
	
	@Before
	public void setup() {
		category = new Category();
		category.setCategoryId("veg123");
		category.setCategoryName("veg");
		restaurant = new Restaurant();
		restaurant.setRestaurantId("shantsagar123");
		restaurant.setRestaurantName("shanthisagar");
		restaurant.setCategory(category);
		restaurant.setAddress("vijayanagr");
	}
	
	/**
	 * Test method for {@link com.raghu.restaurantmanagement.serviceimpl.RestaurantServiceImpl#save(com.raghu.restaurantmanagement.domain.Restaurant)}.
	 */
	@Test
	public void testSaveRestaurant() {
		Mockito.when(restaurantRepository.save(restaurant)).thenReturn(restaurant);
		equals(objectUnderTest.save(restaurant).equals(restaurant));
	}

	/**
	 * Test method for {@link com.raghu.restaurantmanagement.serviceimpl.RestaurantServiceImpl#get(java.lang.String)}.
	 */
	@Test
	public void testGetRestaurantById() {
		Mockito.when(restaurantRepository.findOne("shantsagar123")).thenReturn(restaurant);
		equals(objectUnderTest.get("shantsagar123").equals(restaurant));
	}

	/**
	 * Test method for {@link com.raghu.restaurantmanagement.serviceimpl.RestaurantServiceImpl#getAllRestaurantByCategoryId(java.lang.String)}.
	 */
	@Test
	public void testGetOneRestaurantByCategoryId() {
		List<Restaurant> restauratList=new ArrayList<Restaurant>();
		restauratList.add(restaurant);
		Mockito.when(restaurantRepository.findtByCategoryId("veg123")).thenReturn(restauratList);
		equals(objectUnderTest.getAllRestaurantByCategoryId("veg123").get(0).equals(restaurant));
		}
	
	@Test
	public void testGetTwoRestaurantWithCategory() {
		List<Restaurant> restauratList=new ArrayList<Restaurant>();
		Restaurant restaurant2 = new Restaurant();
		restaurant2.setRestaurantId("udupi123");
		restaurant2.setRestaurantName("udupi");
		restaurant2.setCategory(category);
		restaurant2.setAddress("vijayanagr");
		restauratList.add(restaurant);
		restauratList.add(restaurant2);
		Mockito.when(restaurantRepository.findtByCategoryId("veg123")).thenReturn(restauratList);
		equals(objectUnderTest.getAllRestaurantByCategoryId("veg123").get(0).equals(restaurant));
		equals(objectUnderTest.getAllRestaurantByCategoryId("veg123").get(1).equals(restaurant2));
	}
	
	@Test
	public void testGetTwoRestaurantWithTwoCategory() {
		List<Restaurant> restauratList=new ArrayList<Restaurant>();
		Category category2=new Category();
		category2.setCategoryId("non-veg123");
		category2.setCategoryName("non-veg");
		Restaurant restaurant2 = new Restaurant();
		restaurant2.setRestaurantId("biryani123");
		restaurant2.setRestaurantName("BiryaniZone");
		restaurant2.setCategory(category2);
		restaurant2.setAddress("vijayanagr");
		restauratList.add(restaurant);
		restauratList.add(restaurant2);
		Mockito.when(restaurantRepository.findtByCategoryId("veg123")).thenReturn(restauratList);
		equals(objectUnderTest.getAllRestaurantByCategoryId("veg123").get(0).equals(restaurant));
		equals(objectUnderTest.getAllRestaurantByCategoryId("veg123").get(1).equals(restaurant2));
		equals(objectUnderTest.getAllRestaurantByCategoryId("veg123").get(0).getCategory().equals(category));
		equals(objectUnderTest.getAllRestaurantByCategoryId("veg123").get(1).getCategory().equals(category2));
	}
	
	
	@Configuration
	static class RestaurantServiceTestContextConfiguration {

		@Bean
		public RestaurantService restaurantService(){
			return new RestaurantServiceImpl();
		}

		@Bean
		public RestaurantRepository restaurantRepository() {
			return Mockito.mock(RestaurantRepository.class);
		}
	}

	
}
