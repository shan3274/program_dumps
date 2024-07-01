package com.accenture.lkm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.lkm.business.bean.RegisterBean;
import com.accenture.lkm.service.ReportService;

@RestController
public class ReportController 
{
	@Autowired
	private ReportService reportService;
	
	@RequestMapping(value="report.htm",method=RequestMethod.GET)
	public ModelAndView getParticipants()
	{
		ModelAndView mv=new ModelAndView();
		List<RegisterBean> list=reportService.getAllDetails();
		mv.setViewName("report");
		mv.addObject("list",list);
		return mv;
	}
}
