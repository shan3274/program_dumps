package com.accenture.lkm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.lkm.business.bean.BillRangeBean;
import com.accenture.lkm.business.bean.PizzaOrderBean;
import com.accenture.lkm.service.PizzaService;

@Controller
public class ReportController {

	@Autowired
	PizzaService pizzaService;
	
	@RequestMapping("/loadReportPage.html")
	public ModelAndView loadDateRangeReportPage() {
		return new ModelAndView("OrderReport", "billRangeBean", new BillRangeBean());
	}
	
	@RequestMapping(value="/fetchOrder.html", method = RequestMethod.POST)
	public ModelAndView getOrderDetails(@ModelAttribute("billRangeBean")BillRangeBean billRangeBean) throws Exception {
		List<PizzaOrderBean> pizzaList=pizzaService.getOrderDetails(billRangeBean.getFromBill(), billRangeBean.getToBill());
		ModelAndView mv=new ModelAndView();
		mv.setViewName("OrderReport");
		mv.addObject("pizzaList", pizzaList);
		return mv;
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
