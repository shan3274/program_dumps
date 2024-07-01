package com.accenture.lkm.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.lkm.business.bean.BillBean;
import com.accenture.lkm.business.bean.DateRangeBean;
import com.accenture.lkm.business.bean.TestBean;
import com.accenture.lkm.service.TestService;

@Controller
public class TestController {

	@Autowired
	private TestService testService;
	
	@RequestMapping("/loadAddBillDetailsPage")
	public ModelAndView loadAddBillDetailsPage() {
		return new ModelAndView("AddBill", "billBean", new BillBean());
	}
	
	@RequestMapping("/addBillDetails")
	public ModelAndView addBillDetails(@ModelAttribute("billBean")BillBean billBean) {
		ModelAndView mv = new ModelAndView();
		billBean.setTestName(testService.getTestById(billBean.getTestId()).getTestName());
		billBean.setBalanceAmount(testService.getTestById(billBean.getTestId()).getCharges()-billBean.getPaidAmount());
		BillBean bean = testService.addBillDetails(billBean);
		mv.setViewName("AddBillSuccess");
		mv.addObject("message", "Added bill details successfully with bill number: "+bean.getBillNo()+". Balance amount to be paid= "+billBean.getBalanceAmount());
		return mv;
	}
	
	@RequestMapping("/loadGetBillDetailsPage")
	public ModelAndView getBillDetailsPage() {
		return new ModelAndView("GetBill", "dateRangeBean", new DateRangeBean());
	}
	
	@RequestMapping("/getBillDetails")
	public ModelAndView getBillDetails(@ModelAttribute("dateRangeBean")DateRangeBean dateRangeBean) {
		List<BillBean> billList = testService.getTestBillDetails(dateRangeBean.getFrom(), dateRangeBean.getTo());
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("GetBill");
		mv.addObject("billList", billList);
		return mv;
	}
	
	@ModelAttribute("testMap")
	public Map<Integer, String> populateTestMap() {
//		List<TestBean> testList = testService.findAllTest();
//		Map<Integer, String> testMap = new HashMap<Integer, String>(); 
//		for(TestBean bean:testList) {
//			testMap.put(bean.getTestId(), bean.getTestName());
//		}
		Map<Integer, String> testMap = testService.populateTestMap();
		return testMap;
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
