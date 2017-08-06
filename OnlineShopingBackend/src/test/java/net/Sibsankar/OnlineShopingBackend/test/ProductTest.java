package net.Sibsankar.OnlineShopingBackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.Sibsankar.OnlineShopingBackend.Dao.ProductDAO;

public class ProductTest {
	
private static AnnotationConfigApplicationContext context;
	
	
	private static ProductDAO productDAO;
	
	
	//private Product product;
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.Sibsankar.OnlineShopingBackend");
		context.refresh();
		productDAO = (ProductDAO)context.getBean("productDAO");
	}
	
	/*@Test
	public void testCRUDProduct() {*/
		
		// create operation
		//product = new Product();
				
		/*product.setName("SCALCANDY-BASS_BOOST");
		product.setBrand("SCALCANDY");
		product.setDescription("This is some description for NEW SCALCANDY BASSBOOST!");
		product.setUnitPrice(1000);
		product.setActive(true);
		product.setCategoryId(4);
		product.setSupplierId(1);
		
		assertEquals("Something went wrong while inserting a new product!",
				true,productDAO.add(product));	*/	
		
		
	/*	// reading and updating the category
		product = productDAO.get(11);
		product.setName("DELL INSPIRAN 15P-027TX");
		assertEquals("Something went wrong while updating the existing record!",
				true,productDAO.update(product));		
				
		//assertEquals("Something went wrong while deleting the existing record!",
				//true,productDAO.delete(product));		
		
		// list
		assertEquals("Something went wrong while fetching the list of products!",
				7,productDAO.list().size());
	}
  }	*/
	
	/*@Test
	public void testListActiveProducts() {
		assertEquals("Something went wrong while fetching the list of products!",
				2,productDAO.listOfActiveProduct().size());				
	} */
	
	
	@Test
	public void testListActiveProductsByCategory() {
		assertEquals("Something went wrong while fetching the list of products!",
				2,productDAO.listOfActiveProductByCategory(3).size());
		assertEquals("Something went wrong while fetching the list of products!",
				2,productDAO.listOfActiveProductByCategory(1).size());
	  }
	}
	
  /*   @Test
	public void testGetLatestActiveProduct() {
		assertEquals("Something went wrong while fetching the list of products!",
				2,productDAO.getLatestActiveProduct(2).size());*/
		 

