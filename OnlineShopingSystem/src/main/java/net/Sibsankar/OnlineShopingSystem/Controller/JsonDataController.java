package net.Sibsankar.OnlineShopingSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.Sibsankar.OnlineShopingBackend.Dao.ProductDAO;
import net.Sibsankar.OnlineShopingBackend.domain.Product;

@Controller
@RequestMapping(value="/json")
public class JsonDataController {
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value="/all/product")
	@ResponseBody
	public List<Product> getAllActiveProduct(){
		return productDAO.listOfActiveProduct();
		
	}

	
	@RequestMapping(value="/category/{id}/product")
	@ResponseBody
	public List<Product> getProductByCategory(@PathVariable("id") int id){
		return productDAO.listOfActiveProductByCategory(id);
		
	}
	@RequestMapping(value="/admin/all/product")
	@ResponseBody
	public List<Product> getAllProductForAdmin(){
		return productDAO.list();
		
	}
	
	
}
