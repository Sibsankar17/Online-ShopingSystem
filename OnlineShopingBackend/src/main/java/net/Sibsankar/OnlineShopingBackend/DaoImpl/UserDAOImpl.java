package net.Sibsankar.OnlineShopingBackend.DaoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.Sibsankar.OnlineShopingBackend.Dao.UserDAO;
import net.Sibsankar.OnlineShopingBackend.domain.Address;
import net.Sibsankar.OnlineShopingBackend.domain.Cart;
import net.Sibsankar.OnlineShopingBackend.domain.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addNewUser(User user) {

		try {

			sessionFactory.getCurrentSession().persist(user);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public User getByEmail(String email) {
		String hql = "FROM User WHERE email = :email";
		try {

			return sessionFactory.getCurrentSession().createQuery(hql, User.class).setParameter("email", email)
					.getSingleResult();

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}

	@Override
	public boolean addAddress(Address address) {

		try {

			sessionFactory.getCurrentSession().persist(address);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public Address getBillingAddress(int userId) {

		String hql2 = "FROM Address WHERE userId = :userId AND billing = :billing";

		try {
			return sessionFactory.getCurrentSession().createQuery(hql2, Address.class).setParameter("userId", userId)
					.setParameter("billing", true).getSingleResult();

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Address> listShippingAddresses(int userId) {

		String hql3 = "FROM Address WHERE userId = :userId AND shipping = :shipping";

		try {

			return sessionFactory.getCurrentSession().createQuery(hql3, Address.class).setParameter("userId", userId)
					.setParameter("shipping", true).getResultList();

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean updateCart(Cart cart) {

		try {

			sessionFactory.getCurrentSession().update(cart);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
