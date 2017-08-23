package net.Sibsankar.OnlineShopingBackend.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;

@Entity(name="ADDRESS")
public class Address implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name = "user_id")
	private int userId;
	@NotBlank(message="Please  fill address line1" )
	@Column(name="ADDRESS_LINE_1")
	private String address1;
	@Column(name="ADDRESS_LINE_2")
	@NotBlank(message="Please  fill address line2 ")
	private String address2;
	@NotBlank(message="Please  fill city field")
	private String city;
	@NotBlank(message="Please  fill state field ")
	private String state;
	private String country;
	@Column(name="PIN_CODE")
	@NotBlank(message="Please  fill proper pincode ")
	private String pincode;
	private boolean billing;
	private boolean shiping;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public boolean isBilling() {
		return billing;
	}
	public void setBilling(boolean billing) {
		this.billing = billing;
	}
	public boolean isShiping() {
		return shiping;
	}
	public void setShiping(boolean shiping) {
		this.shiping = shiping;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", userId=" + userId + ", address1=" + address1 + ", address2=" + address2
				+ ", city=" + city + ", state=" + state + ", country=" + country + ", pincode=" + pincode + ", billing="
				+ billing + ", shiping=" + shiping + "]";
	}
	
	
	

}
