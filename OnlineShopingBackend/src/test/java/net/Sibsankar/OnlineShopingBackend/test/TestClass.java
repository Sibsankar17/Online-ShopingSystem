package net.Sibsankar.OnlineShopingBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.Sibsankar.OnlineShopingBackend.Dao.CategoryDAO;
import net.Sibsankar.OnlineShopingBackend.domain.Category;

public class TestClass {

	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private Category category;
	@BeforeClass
	public static void init(){
		context=new AnnotationConfigApplicationContext();
		context.scan("net.Sibsankar.OnlineShopingBackend");
		context.refresh();
		
		categoryDAO=(CategoryDAO) context.getBean("categoryDAO");
		
	}
	/*@Test
	public void testCategory(){
		
		category=new Category();
		category.setName("Laptop");
		category.setDescipation("This is a Laptop");
		category.setImegeUrl("imege1.png");
		assertEquals("Sucessfully added", true,categoryDAO.add(category));
		
	}*/
	/*@Test
	public void testGetCategory(){
		
		category=categoryDAO.get(1);
		assertEquals("Sucessfully fetch","Mobile",category.getName());
		
	}*/
	/*@Test
	public void testUpdteCategory(){
		
		category=categoryDAO.get(1);
		category.setName("Motorola Mobile");
		assertEquals("Sucessfully update",true,categoryDAO.update(category));
		
	}*/
	@Test
	public void testDeleteCategory(){
		
		category=categoryDAO.get(2);
		assertEquals("Sucessfully deleted",true,categoryDAO.delete(category));
		
	}
	
}
