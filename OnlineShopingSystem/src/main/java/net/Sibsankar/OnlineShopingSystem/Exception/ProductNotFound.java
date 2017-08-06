package net.Sibsankar.OnlineShopingSystem.Exception;

import java.io.Serializable;

public class ProductNotFound extends Exception implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	public ProductNotFound(){
		this("Product is Not found");
	}
	public ProductNotFound(String message){
		this.message=System.currentTimeMillis()+ ":"+message;
	}
	public String getMessage() {
		return message;
	}
	
}
