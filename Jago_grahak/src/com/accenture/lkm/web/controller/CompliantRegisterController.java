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

import com.accenture.lkm.business.bean.CompliantBean;
import com.accenture.lkm.service.CompliantService;

@Controller
public class CompliantRegisterController {

	@Autowired
	private CompliantService compliantService;
	
	@RequestMapping(value = "/loadCompliantForm.html")
	public ModelAndView loadCompliantForm() {
		return new ModelAndView("CompliantPage","compliantBean",new CompliantBean());
	}
	
	@RequestMapping(value ="/processCompliantForm.html", method = RequestMethod.POST)
	public ModelAndView processCompliantForm(@ModelAttribute("compliantBean")@Valid CompliantBean bean,BindingResult result) throws Exception {
		ModelAndView mv=new ModelAndView();
		if(result.hasErrors()) {
			mv.setViewName("CompliantPage");
		}
		else {
			compliantService.registerCompliantDetails(bean);
			mv.setViewName("Success");
			mv.addObject("message", "Hi "+bean.getCustomerName()+" your compliant is successful registered.");
		}
		return mv;
	}
	
	@ModelAttribute("types")
	public Map<Integer,String> getAllCompliantTypes(){
		return compliantService.getAllCompliantTypes();
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
