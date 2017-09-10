package net.Sibsankar.OnlineShopingBackend.DaoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.Sibsankar.OnlineShopingBackend.Dao.ProductDAO;
import net.Sibsankar.OnlineShopingBackend.domain.Product;
@Repository("productDAO")
@Transactional
public class ProductDaoImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Product get(int productId) {

		try {
			return sessionFactory.getCurrentSession().get(Product.class,Integer.valueOf(productId));
		} catch (Exception ex) {
			ex.printStackTrace();
			
		}
		return null;
	}

	@Override
	public List<Product> list() {
			
			return sessionFactory.getCurrentSession().createQuery("FROM Product",Product.class).getResultList();


	}



	public boolean add(Product product) {
		try {
			sessionFactory.getCurrentSession().persist(product);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Product product) {

		product.setActive(false);
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			
		}
		return false;
	}

	@Override
	public boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			
		}
		return false;
	}

	@Override
	public List<Product> listOfActiveProduct() {
		
		String activeProduct="FROM Product WHERE active = :active";
		return sessionFactory.getCurrentSession().createQuery(activeProduct, Product.class)
				.setParameter("active", true).getResultList();
	}

	@Override
	public List<Product> listOfActiveProductByCategory(int categoryId) {
		String activeProductCategory="FROM Product WHERE active = :active AND categoryId = :categoryId";
		return sessionFactory.getCurrentSession().createQuery(activeProductCategory, Product.class)
				.setParameter("active", true)
				.setParameter("categoryId", categoryId )
				.getResultList();
	}

	@Override
	public List<Product> getLatestActiveProduct(int count) {
		String activeLatestProduct="FROM Product WHERE active = :active ORDER BY id";
		return sessionFactory.getCurrentSession().createQuery(activeLatestProduct, Product.class)
				.setParameter("active", true)
			     .setFirstResult(0)
			     .setMaxResults(count)
				   .getResultList();
	}

}
