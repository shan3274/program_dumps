package com.accenture.lkm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.lkm.business.bean.CompliantBean;
import com.accenture.lkm.business.bean.DateRangeBean;
import com.accenture.lkm.service.CompliantService;

@Controller
public class CompliantReportController {

	@Autowired
	private CompliantService compliantService;
	
	@RequestMapping(value = "/loadCompliantReport.html")
	public ModelAndView loadCompliantReport() {
		return new ModelAndView("CompliantReport","dateRangeBean",new DateRangeBean());
	}
	
	@RequestMapping(value = "/getDetails.html", method = RequestMethod.POST)
	public ModelAndView getCompliantDetailsByDate(@ModelAttribute("dateRangeBean") DateRangeBean dateRange) {
		ModelAndView mv=new ModelAndView();
		List<CompliantBean> compliants=compliantService.getCompliantDetailsByDate(dateRange.getFromDate(), dateRange.getToDate());
		mv.setViewName("ShowCompliantDetails");
		mv.addObject("compliants", compliants);
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
