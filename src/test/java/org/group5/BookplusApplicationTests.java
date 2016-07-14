package org.group5;

import org.group5.dao.BookDao;
import org.group5.dao.CategoryDao;
import org.group5.model.Book;
import org.group5.model.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MainApp.class)
@WebAppConfiguration
public class BookplusApplicationTests {
	@Autowired BookDao bookDao;
	@Autowired
	CategoryDao categoryDao;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testTop6Book(){
		Set<Book> bookSet = bookDao.findFirst6ByOrderByIdDesc();
		assertEquals(6,bookSet.size());

	}


	@Test
	public void testTop2DiscountedBook(){
		Set<Book> bookSet = bookDao.findFirst2ByOrderByDiscountDesc();
		assertEquals(2,bookSet.size());

	}

	@Test
	public  void testGetBookByCategory(){
		Category category = categoryDao.findOne(2L);
		Set<Book> bookSet = bookDao.findBookByCategory(category);
		assertEquals(3,bookSet.size());
	}

}
