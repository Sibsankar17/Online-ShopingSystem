package net.Sibsankar.OnlineShopingSystem.valid;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import net.Sibsankar.OnlineShopingBackend.domain.Product;

public class ProoductValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors error) {
		Product product=(Product)target;
		if(product.getFile()==null ||product.getFile().getOriginalFilename().equals("")){
			error.rejectValue("file", null,"Please Select an Image");
			return;
		}
		if(!(
			 product.getFile().getContentType().equals("image/jpeg")||
			 product.getFile().getContentType().equals("image/png")||
			 product.getFile().getContentType().equals("image/gif")
			 )){
			error.rejectValue("file", null, "Select only Image file");
		}
			

	}

}
