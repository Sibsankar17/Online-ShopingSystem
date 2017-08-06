package net.Sibsankar.OnlineShopingBackend.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.NumberFormat;

@Entity(name="USER_DETAIL")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@OneToOne(mappedBy="user",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Cart cart;
	@Column(name="FIRST_NAME")
	@NotBlank(message="Please  Enter Your First name")
	private String firstName;
	@Column(name="LAST_NAME")
	@NotBlank(message="Please enter Your Last Name")
	private String lastName;
	@Column(name="ROLE")
	@NotBlank(message="Please  select the Role")
	private String role;
	private boolean enabled=true;
	@NotBlank(message="Please enter a password")
	private String password;
	@Transient
	private String confirmPassword;
	@Column(unique=true)
	@Email
	private String email;
	@Column(name="CONTACT_NUMBER")
	@NotBlank(message="Please  enter your Contact number")
	@NumberFormat
	private String contactNumber;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", cart=" + cart + ", firstName=" + firstName + ", lastName=" + lastName + ", role="
				+ role + ", enabled=" + enabled + ", password=" + password + ", email=" + email + ", contactNumber="
				+ contactNumber + "]";
	}
	
	
}
