package net.Sibsankar.OnlineShopingSystem.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@RequestMapping(value = { "/", "home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		mv.addObject("onClickHome",true);
		return mv;
	}
	@RequestMapping(value ="/contact")
	public ModelAndView contactUs() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact");
		mv.addObject("onClickContact",true);
		return mv;
	}
	@RequestMapping(value ="/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About");
		mv.addObject("onClickAbout",true);
		return mv;
	}
	@RequestMapping(value ="/listproduct")
	public ModelAndView productAll() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Product");
		mv.addObject("onClickProduct",true);
		return mv;
	}

}
