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
	public Product get(int id) {

		try {
			return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(id));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> list() {
		try {
			
			return sessionFactory.getCurrentSession().createQuery("from Product",Product.class).getResultList();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;

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
		
		String activeProduct="from Product where active=:active";
		return sessionFactory.getCurrentSession().createQuery(activeProduct, Product.class)
				.setParameter("active", true).getResultList();
	}

	@Override
	public List<Product> listOfActiveProductByCategory(int categoryId) {
		String activeProductCategory="from Product where  categoryId=:categoryId AND active=:active ";
		return sessionFactory.getCurrentSession().createQuery(activeProductCategory, Product.class)
				.setParameter("active", true)
				.setParameter("categoryId", categoryId )
				.getResultList();
	}

	@Override
	public List<Product> getLatestActiveProduct(int count) {
		String activeLatestProduct="from Product where active=:active ORDER BY id";
		return sessionFactory.getCurrentSession().createQuery(activeLatestProduct, Product.class)
				.setParameter("active", true)
			     .setFirstResult(0)
			     .setMaxResults(count)
				   .getResultList();
	}

}
