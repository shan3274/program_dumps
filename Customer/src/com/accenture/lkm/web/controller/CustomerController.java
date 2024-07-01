package com.accenture.lkm.web.controller;

import java.util.Map; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.ExceptionHandler; 
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView; 

import com.accenture.lkm.business.bean.CustomerBean;
import com.accenture.lkm.service.CustomerService; 

@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@RequestMapping("/addCustomerURL.html")
	public ModelAndView loadCustomerForm() {
		return new ModelAndView("CreateCustomer","customerBean", new CustomerBean());
	}

	@RequestMapping(value="/saveCustomer.html", method = RequestMethod.POST )
	public ModelAndView saveCustomer(@ModelAttribute("customerBean")CustomerBean customerBean) throws Exception{
		ModelAndView mv = new ModelAndView();
		Integer id = customerService.addCustomer(customerBean);
		mv.setViewName("CreateCustomerSuccess");
		mv.addObject("message", "Customer added successfully with id:"+ id);
		return mv;
	}

	@ModelAttribute("customerTypesRadio")
	public Map<String, String> populateCustomerType() throws Exception{
		return customerService.getCustomerTypes();
	}



//Error Handler:
	@ExceptionHandler(value=Exception.class)
	public ModelAndView handleAllExceptions(Exception exception){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("GeneralizedExceptionHandlerPage");
		modelAndView.addObject("message", exception.getMessage());
		modelAndView.addObject("exception", exception);
		return modelAndView;
	}

}