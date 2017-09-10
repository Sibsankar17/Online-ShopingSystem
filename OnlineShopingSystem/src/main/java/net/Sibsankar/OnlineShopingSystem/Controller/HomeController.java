package net.Sibsankar.OnlineShopingSystem.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.Sibsankar.OnlineShopingBackend.Dao.CategoryDAO;
import net.Sibsankar.OnlineShopingBackend.Dao.ProductDAO;
import net.Sibsankar.OnlineShopingBackend.domain.Category;
import net.Sibsankar.OnlineShopingBackend.domain.Product;
import net.Sibsankar.OnlineShopingSystem.Exception.ProductNotFound;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private ProductDAO productDAO;

	// @RequestParam(name="logout",required=false) String logout
	@RequestMapping(value = { "/", "home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		/*
		 * if(logout!= null){
		 * mv.addObject("message","You Are Successfully Logout");
		 * 
		 * }
		 */
		mv.addObject("title", "Home");
		logger.info("Inside PageController index method - INFO");
		logger.debug("Inside PageController index method - DEBUG");
		mv.addObject("categories", categoryDAO.findAll());
		mv.addObject("onClickHome", true);

		return mv;
	}

	@RequestMapping(value = "/contact")
	public ModelAndView contactUs() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact");
		mv.addObject("onClickContact", true);
		return mv;
	}

	@RequestMapping(value = "/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About");
		mv.addObject("onClickAbout", true);
		return mv;
	}

	@RequestMapping(value = "/access_reject")
	public ModelAndView accessDenied() {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("title", "Deny");
		mv.addObject("errorTitle", "Do not try to Acceess the admin page");
		mv.addObject("errorDesc", "You are not an ADMIN");
		return mv;
	}

	@RequestMapping(value = "/login")
	public ModelAndView login(@RequestParam(name = "error", required = false) String error) {
		ModelAndView mv = new ModelAndView("login");
		if (error != null) {
			mv.addObject("message", "Email and password are not match");

		}
		mv.addObject("title", "Login");
		return mv;
	}

	@RequestMapping(value = "/show/all/products")
	public ModelAndView product() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Products");
		mv.addObject("categories", categoryDAO.findAll());
		mv.addObject("onClickAllProduct", true);
		return mv;
	}

	@RequestMapping(value = "/show/Category/{id}/products")
	public ModelAndView allProduct(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");
		Category category = null;
		category = categoryDAO.get(id);
		mv.addObject("title", category.getName());
		mv.addObject("categories", categoryDAO.findAll());
		mv.addObject("category", category);
		mv.addObject("onClickCategoryProduct", true);
		return mv;
	}

	/* To view a single product */
	@RequestMapping(value = "/show/{id}/product")
	public ModelAndView showingSingleProduct(@PathVariable("id") int id) throws ProductNotFound {
		ModelAndView mv = new ModelAndView("page");
		Product product = productDAO.get(id);
		if (product == null){
			throw new ProductNotFound();	
		}
			
		product.setViews(product.getViews() + 1);
		productDAO.update(product);
		mv.addObject("title", product.getName());
		mv.addObject("product", product);
		mv.addObject("onClickShowProduct", true);
		return mv;

	}

	@RequestMapping(value = "/perform-logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/home?logout";
	}
}
