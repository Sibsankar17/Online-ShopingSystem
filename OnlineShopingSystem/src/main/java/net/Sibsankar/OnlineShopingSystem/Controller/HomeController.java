package net.Sibsankar.OnlineShopingSystem.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.Sibsankar.OnlineShopingBackend.Dao.CategoryDAO;
import net.Sibsankar.OnlineShopingBackend.Dao.ProductDAO;
import net.Sibsankar.OnlineShopingBackend.domain.Category;
import net.Sibsankar.OnlineShopingBackend.domain.Product;
import net.Sibsankar.OnlineShopingSystem.Exception.ProductNotFound;

@Controller
public class HomeController {
	
	private static  final Logger loger=LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private ProductDAO productDAO;

	@RequestMapping(value = { "/", "home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		loger.info("For HomeController-INFO");
		loger.debug("For PageController-DEBUG");
		mv.addObject("title", "Home");
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
	public ModelAndView showingSingleProduct(@PathVariable("id") int id)throws ProductNotFound {
		ModelAndView mv = new ModelAndView("page");
		Product product = productDAO.get(id);
		if(product==null)throw new ProductNotFound();
		product.setViews(product.getViews() + 1);
		productDAO.update(product);
		mv.addObject("title", product.getName());
		mv.addObject("product", product);
		mv.addObject("onClickShowProduct", true);
		return mv;

	}
}
