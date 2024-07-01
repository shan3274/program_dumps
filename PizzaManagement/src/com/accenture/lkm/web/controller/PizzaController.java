package com.accenture.lkm.web.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.lkm.business.bean.PizzaOrderBean;
import com.accenture.lkm.service.PizzaService;

@Controller
public class PizzaController {

	@Autowired
	private PizzaService pizzaService;
	
	@RequestMapping("/loadPizzaOrderPage.html")
	public ModelAndView loadSavePizza() {
		return new ModelAndView("PizzaOrder", "pizzaOrderBean", new PizzaOrderBean());
	}
	
	@RequestMapping(value="/savePizzaOrder.html", method = RequestMethod.POST)
	public ModelAndView savePizzaOrder(@Valid @ModelAttribute("pizzaOrderBean")PizzaOrderBean pizzaOrderBean, 
																																BindingResult result) {
		ModelAndView mv=new ModelAndView();
		if(result.hasErrors()) {
			mv.setViewName("PizzaOrder");
		}else {
			PizzaOrderBean pBean=pizzaService.addPizzaOrderDetails(pizzaOrderBean);
			mv.setViewName("PizzaOrderSuccess");
			mv.addObject("message", "Hi,"+pBean.getCustomerName()+". your order is place with order id:"+pBean.getOrderId()+
																											", Bill to paid is Rs."+pBean.getBill());
		}
		return mv;
	}
	@ModelAttribute("pizzaMap")
	public Map<Integer, String> populatePizza(){
		return pizzaService.findAllPizzaDetails();
	}
	
	
	//Error Handler:
	@ExceptionHandler(value=Exception.class)
	public ModelAndView handleAllExceptions(Exception exception){	
		ModelAndView  modelAndView = new ModelAndView();
		modelAndView.setViewName("GeneralizedExceptionHandlerPage");
		modelAndView.addObject("message", exception.getMessage());
		modelAndView.addObject("exception", exception);
		return modelAndView;
	}
	
}
