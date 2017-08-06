package net.Sibsankar.OnlineShopingBackend.Dao;

import java.util.List;

import net.Sibsankar.OnlineShopingBackend.domain.Address;
import net.Sibsankar.OnlineShopingBackend.domain.Cart;
import net.Sibsankar.OnlineShopingBackend.domain.User;

public interface UserDAO {
	
	// add an user
		boolean addNewUser(User user);
		User getByEmail(String email);
		
		// add an address
		boolean addAddress(Address address);
		// alternative
		 Address getBillingAddress(int userId);
		 List<Address> listShippingAddresses(int userId);
		
	/*	
		Address getBillingAddress(User user);
		List<Address> listShippingAddresses(User user);
	*/
		
		// udpate a cart
		boolean updateCart(Cart cart);

}
