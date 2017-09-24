/**
 * 
 */
package com.raghu.restaurantmanagement.serviceimpl;

import static org.junit.Assert.assertEquals;

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
import com.raghu.restaurantmanagement.repositories.CategoryRepository;
import com.raghu.restaurantmanagement.service.CategoryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class CategoryServiceImplTest {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private CategoryService objectUnderTest;
	private Category category;

	@Before
	public void setup() {
		category = new Category();
		category.setCategoryId("veg123");
		category.setCategoryName("veg");
	}

	/**
	 * Test method for
	 * {@link com.raghu.restaurantmanagement.serviceimpl.CategoryServiceImpl#save(com.raghu.restaurantmanagement.domain.Category)}
	 * .
	 */
	@Test
	public void testSave() {
		Mockito.when(categoryRepository.save(category)).thenReturn(category);
		assertEquals(category, objectUnderTest.save(category));
	}

	/**
	 * Test method for
	 * {@link com.raghu.restaurantmanagement.serviceimpl.CategoryServiceImpl#get(java.lang.String)}
	 * .
	 */
	@Test
	public void testGet() {
		Mockito.when(categoryRepository.findOne("veg123")).thenReturn(category);
		assertEquals(category, objectUnderTest.get("veg123"));
	}

	/**
	 * Test method for
	 * {@link com.raghu.restaurantmanagement.serviceimpl.CategoryServiceImpl#getAllCategory()}
	 * .
	 */
	@Test
	public void testGetAllCategory() {
		List<Category> categoryList = new ArrayList<Category>();
		categoryList.add(category);
		Mockito.when(categoryRepository.findAll()).thenReturn(categoryList);
		equals(objectUnderTest.getAllCategory().equals(categoryList));
	}

	@Configuration
	static class CategoryServiceTestContextConfiguration {

		@Bean
		public CategoryService categoryService() {
			return new CategoryServiceImpl();
		}

		@Bean
		public CategoryRepository categoryRepository() {
			return Mockito.mock(CategoryRepository.class);
		}
	}

}
