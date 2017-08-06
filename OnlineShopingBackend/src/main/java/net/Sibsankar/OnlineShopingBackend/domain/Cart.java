package net.Sibsankar.OnlineShopingBackend.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Cart implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue
	private int Id;
	@OneToOne
	@JoinColumn(name="userId")
	private User user;
	private Double grandTotal;
	private int cartline;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Double getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(Double grandTotal) {
		this.grandTotal = grandTotal;
	}
	public int getCartline() {
		return cartline;
	}
	public void setCartline(int cartline) {
		this.cartline = cartline;
	}
	
	
	
	

}
