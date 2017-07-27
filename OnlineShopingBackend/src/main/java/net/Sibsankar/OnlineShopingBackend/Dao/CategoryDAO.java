package net.Sibsankar.OnlineShopingBackend.Dao;

import java.util.List;

import net.Sibsankar.OnlineShopingBackend.domain.Category;

public interface CategoryDAO {

	List<Category> list();

	Category get(int id);

	boolean add(Category category);

	boolean update(Category category);

	boolean delete(Category category);
}
