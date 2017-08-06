package net.Sibsankar.OnlineShopingSystem.Exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class DefaultExceptionHandler {
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView noHandelerFound(){
		ModelAndView mv=new ModelAndView("error");
		mv.addObject("errorTitle","Page IS not Created yet..." );
		mv.addObject("errorDesc", "Page Not Found");
		mv.addObject("title", "Error");
		return mv;
	}
	
	@ExceptionHandler(ProductNotFound.class)
	public ModelAndView noProductFound(){
		ModelAndView mv=new ModelAndView("error");
		mv.addObject("errorTitle","Product is not Available" );
		mv.addObject("errorDesc", "Page Not Found");
		mv.addObject("title", "No Product");
		return mv;
	}
	@ExceptionHandler(Exception.class)
	public ModelAndView notFound(Exception ex){
		ModelAndView mv=new ModelAndView("error");
		mv.addObject("errorTitle","Error" );
		mv.addObject("errorDesc", "No Macth with product ID: "+ex.toString());
		mv.addObject("title", "No Product");
		return mv;
	}
}
