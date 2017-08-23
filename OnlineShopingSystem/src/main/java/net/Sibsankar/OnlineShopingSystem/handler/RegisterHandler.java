package net.Sibsankar.OnlineShopingSystem.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import net.Sibsankar.OnlineShopingBackend.Dao.UserDAO;
import net.Sibsankar.OnlineShopingBackend.domain.Address;
import net.Sibsankar.OnlineShopingBackend.domain.Cart;
import net.Sibsankar.OnlineShopingBackend.domain.User;
import net.Sibsankar.OnlineShopingSystem.model.RegisterModel;

@Component
public class RegisterHandler {
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public RegisterModel init() {

		return new RegisterModel();
	}

	public void addUser(RegisterModel registerModel, User user) {
		registerModel.setUser(user);
	}

	public void addAddress(RegisterModel registerModel, Address address) {
		registerModel.setAddress(address);
	}

	public String userValidation(User user, MessageContext error) {
		String value = "success";
		if (!user.getPassword().equals(user.getConfirmPassword())) {
			error.addMessage(new MessageBuilder().error()
					.source("confirmPassword").defaultText("Please Enter Same Password").build());
			value = "failure";
		}
		return value;
	}

	public String saveAll(RegisterModel model) {
		String value = "success";
		User user = model.getUser();
		if (user.getRole().equals("USER")) {
			Cart cart = new Cart();
			cart.setUser(user);
			user.setCart(cart);
		}
		/* Password Encoded*/
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		/* SAVE NEW USER */
		userDAO.addNewUser(user);

		Address address = model.getAddress();
		address.setUserId(user.getId());
		address.setBilling(true);
		userDAO.addAddress(address);

		return value;
	}
}
