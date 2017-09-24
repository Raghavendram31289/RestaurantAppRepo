/**
 * 
 */
package com.raghu.restaurantmanagement.controller;

import static org.junit.Assert.assertEquals;

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
import com.raghu.restaurantmanagement.service.CategoryService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class CategoryControllerTest {

	@Autowired
	private CategoryService categoryService;
	private CategoryController objectUnderTest;
	Category category;

	@Before
	public void setup() {
		objectUnderTest = new CategoryController();
		objectUnderTest.setCategoryService(categoryService);
		category = new Category();
		category.setCategoryId("veg123");
		category.setCategoryName("veg");
	}

	/**
	 * Test method for
	 * {@link com.raghu.restaurantmanagement.controller.CategoryController#createCategory(com.raghu.restaurantmanagement.domain.Category)}
	 * .
	 */

	@Test
	public void testCreateCategory() {
		Category category = new Category();
		category.setCategoryId("veg123");
		category.setCategoryName("veg");
		Mockito.when(categoryService.save(category)).thenReturn(category);
		ResponseEntity<Category> responseEntity = objectUnderTest.createCategory(category);
		assertEquals(responseEntity.getStatusCodeValue(), 201);
	}

	/**
	 * Test method for
	 * {@link com.raghu.restaurantmanagement.controller.CategoryController#getCategory(java.lang.String)}
	 * .
	 */
	@Test
	public void testGetCategory() {
		Mockito.when(categoryService.get("veg123")).thenReturn(category);
		ResponseEntity<Category> responseEntity = objectUnderTest.getCategory("veg123");
		assertEquals(responseEntity.getStatusCodeValue(), 200);
	}
	
	@Test
	public void testNotFoundCategory() {
		Mockito.when(categoryService.get("veg123")).thenReturn(category);
		ResponseEntity<Category> responseEntity = objectUnderTest.getCategory("someothervalue");
		assertEquals(responseEntity.getStatusCode(), HttpStatus.NOT_FOUND);
	}

	@Configuration
	static class CategoryControllerTestContextConfiguration {
		@Bean
		public CategoryService categoryService() {
			return Mockito.mock(CategoryService.class);
		}
	}

}
