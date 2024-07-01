package com.accenture.lkm.web.controller;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler; 
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod; 
import org.springframework.web.servlet.ModelAndView; 

import com.accenture.lkm.business.bean.CustomerBean;
import com.accenture.lkm.business.bean.DateRangeBean; 
import com.accenture.lkm.service.CustomerService;

@Controller
public class ReportController {
	@Autowired
	private CustomerService customerService;

	@RequestMapping("/showCustomerDetails.html")
	public ModelAndView loadReportPage(){
		return new ModelAndView("CustomerDetails", "dateRangeBean",new DateRangeBean());
	}

	@RequestMapping(value="/displayCustomerRecordsURL.html",method=RequestMethod.GET)
	public ModelAndView getCustomerRecords(@ModelAttribute("dateRangeBean") DateRangeBean dateRangeBean) throws Exception{
		ModelAndView mv = new ModelAndView();
		List<CustomerBean> beanList = customerService.getCustomerDetails(dateRangeBean.getFromDate(),dateRangeBean.getToDate());
		mv.setViewName("CustomerDetails");
		mv.addObject("beanList", beanList);
	//System.out.println(beanList);
		return mv;

	}

	//Error Handler:
	@ExceptionHandler(value=Exception.class)
	public ModelAndView handleAllExceptions(Exception exception){
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("GeneralizedExceptionHandlerPage");
		modelAndView.addObject("message",
				exception.getMessage());
		modelAndView.addObject("exception", exception);
		return modelAndView;
	}

}
