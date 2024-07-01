package com.accenture.lkm.web.controller;

import java.util.ArrayList;
import java.util.List;
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

import com.accenture.lkm.business.bean.BurgerBean;
import com.accenture.lkm.service.BurgerService;

@Controller
public class BurgerController {

	@Autowired
	private BurgerService burgerService;
	
	@RequestMapping(value = "/LoadBurgerOrder", method = RequestMethod.GET)
    public ModelAndView showPage() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("orderpage");
		mv.addObject("burgerBean",new BurgerBean());
		return mv;
	}
	
	@RequestMapping(value = "/OrderBurger", method = RequestMethod.POST)
    public ModelAndView orderBurger(@Valid @ModelAttribute("burgerBean") BurgerBean burgerBean,
    		BindingResult result) throws Exception{
		ModelAndView mv = new ModelAndView();
		if(result.hasErrors()) {
			mv.setViewName("orderpage");
		}
		else {
			Double bill = burgerService.calculateTotalCost(burgerBean);
			mv.setViewName("successorder");
			mv.addObject("message","Thank you for choosing our Service. You need to pay Rs."
					+bill+" on delivery");
		}
		return mv;
	}
	
	@ModelAttribute("burgerList")
	public List<String> getBurgers() throws Exception {
		Map<String, Double> map = burgerService.getBurgerDetails();
		List<String> burgers = new ArrayList<String>();
		for(String key : map.keySet()) {
			burgers.add(key);
		}
		return burgers;
	}
	
	@ModelAttribute("toppingList")
	public List<String> getToppings() throws Exception {
		Map<String, Double> map = burgerService.getToppingDetails();
		List<String> toppings = new ArrayList<String>();
		for(String key : map.keySet()) {
			toppings.add(key);
		}
		return toppings;
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
