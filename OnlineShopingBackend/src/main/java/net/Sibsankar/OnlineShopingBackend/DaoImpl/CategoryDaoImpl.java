package net.Sibsankar.OnlineShopingBackend.DaoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.Sibsankar.OnlineShopingBackend.Dao.CategoryDAO;
import net.Sibsankar.OnlineShopingBackend.domain.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDaoImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Category> findAll() {
		
		String hql="FROM Category  WHERE active = :active";
		
       return sessionFactory.getCurrentSession().createQuery(hql,Category.class).setParameter("active", true).getResultList();
	}

	@Override
	public Category get(int id) {

		try {
			return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean add(Category category) {
		try {
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
		
	}

	@Override
	public boolean update(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean delete(Category category) {
	  category.setActive(false);
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
	}
}
