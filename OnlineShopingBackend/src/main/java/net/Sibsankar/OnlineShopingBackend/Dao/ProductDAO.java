package net.Sibsankar.OnlineShopingBackend.Dao;

import java.util.List;

import net.Sibsankar.OnlineShopingBackend.domain.Product;

public interface ProductDAO {

	Product get(int id);

	List<Product> list();

	boolean add(Product product);

	boolean delete(Product product);

	boolean update(Product product);

	List<Product> listOfActiveProduct();

	List<Product> listOfActiveProductByCategory(int categoryId);

	List<Product> getLatestActiveProduct(int count);

}
