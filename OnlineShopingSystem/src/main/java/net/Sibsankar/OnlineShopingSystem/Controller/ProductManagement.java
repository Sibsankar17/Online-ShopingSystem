package net.Sibsankar.OnlineShopingSystem.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.Sibsankar.OnlineShopingBackend.Dao.CategoryDAO;
import net.Sibsankar.OnlineShopingBackend.Dao.ProductDAO;
import net.Sibsankar.OnlineShopingBackend.domain.Category;
import net.Sibsankar.OnlineShopingBackend.domain.Product;
import net.Sibsankar.OnlineShopingSystem.Upload.FileUpload;
import net.Sibsankar.OnlineShopingSystem.valid.ProoductValidation;

@Controller
@RequestMapping(value = "/manage")
public class ProductManagement {
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private ProductDAO productDAO;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView manageProduct(@RequestParam(name = "save", required = false) String save) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("onClickManageProduct", true);
		mv.addObject("title", "ProductManagement");
		Product product = new Product();
		product.setSupplierId(1);
		product.setActive(true);
		mv.addObject("product", product);
		if (save != null) {
			if (save.equals("product")) {
				mv.addObject("saveMessage", "PRODUCT ADDED SUCESSFULLY");
			} else {
				if (save.equals("category")) {
					mv.addObject("saveMessage", "CATEGORY ADDED SUCESSFULLY");

				}
			}

		}
		return mv;
	}

	@RequestMapping(value = "/{id}/product", method = RequestMethod.GET)
	public ModelAndView editProduct(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("onClickManageProduct", true);
		mv.addObject("title", "ProductManagement");
		Product product = productDAO.get(id);
		mv.addObject("product", product);
		return mv;
	}

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String saveProduct(@Valid @ModelAttribute("product") Product newProduct, BindingResult results, Model model,
			HttpServletRequest request) {
		//Inserting images Validation
		if (newProduct.getId() == 0) {
			new ProoductValidation().validate(newProduct, results);
		} else {
			if (!newProduct.getFile().getOriginalFilename().equals("")) {
				new ProoductValidation().validate(newProduct, results);
			}
		}
       //For Eror in product Form
		if (results.hasErrors()) {
			model.addAttribute("onClickManageProduct", true);
			model.addAttribute("title", "ProductManagement");
			return "page";
		}
		//Checking for Existing product
		if (newProduct.getId() == 0) {
			productDAO.add(newProduct);
		} else {
			productDAO.update(newProduct);
		}

		if (!newProduct.getFile().getOriginalFilename().equals("")) {
			FileUpload.uploadFile(request, newProduct.getFile(), newProduct.getCode());
		}
		return "redirect:/manage/products?save=product";
	}

	@RequestMapping(value = "/product/{id}/activation")
	@ResponseBody
	public String activeDeactiveProduct(@PathVariable int id) {
		Product product = productDAO.get(id);
		boolean isActive = product.isActive();
		product.setActive(!product.isActive());
		productDAO.update(product);
		return (isActive) ? "Product Is activated" + product.getId() : "Product Is Deactivated" + product.getId();
	}

	@ModelAttribute("categories")
	public List<Category> getAllCategory() {
		return categoryDAO.findAll();
	}

	@ModelAttribute("category")
	public Category getCategory() {
		return new Category();
	}

	@RequestMapping(value = "/category", method = RequestMethod.POST)
	public String saveCategory(@ModelAttribute Category category) {
		categoryDAO.add(category);
		return "redirect:/manage/products?save=category";

	}
}
