package net.Sibsankar.OnlineShopingSystem.model;

import java.io.Serializable;

import net.Sibsankar.OnlineShopingBackend.domain.Address;
import net.Sibsankar.OnlineShopingBackend.domain.User;

public class RegisterModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	private Address address;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	

}
