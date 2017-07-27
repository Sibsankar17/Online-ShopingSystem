package net.Sibsankar.OnlineShopingSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.Sibsankar.OnlineShopingBackend.Dao.CategoryDAO;
import net.Sibsankar.OnlineShopingBackend.domain.Category;

@Controller
public class HomeController {

	@Autowired
	private CategoryDAO categoryDAO;

	@RequestMapping(value = { "/", "home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		mv.addObject("categories", categoryDAO.list());
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

	@RequestMapping(value ="/show/all/products")
	public ModelAndView product() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Products");
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("onClickAllProduct", true);
		return mv;
	}
	@RequestMapping(value = "/show/Category/{id}/products")
	public ModelAndView allProduct(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");
		Category category=null;
		category=categoryDAO.get(id);
		mv.addObject("title", category.getName());
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("category", category);
		mv.addObject("onClickCategoryProduct", true);
		return mv;
	}


}
