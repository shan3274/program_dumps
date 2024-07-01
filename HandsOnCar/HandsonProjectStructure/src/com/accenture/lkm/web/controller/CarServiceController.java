package com.accenture.lkm.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.lkm.business.bean.CarServiceBean;
import com.accenture.lkm.business.bean.PartsBean;
import com.accenture.lkm.service.CarService;
import com.accenture.lkm.service.CarServiceImpl;

@Controller
@SessionAttributes("carServiceObj")
public class CarServiceController {

	@Autowired
	private CarService carService;

	@RequestMapping(value = "/LoadCarType", method = RequestMethod.GET)
	public ModelAndView loadCarTypePage() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("CarType");
		mv.addObject("carServiceObj", new CarServiceBean());
		mv.addObject("partsObj", new PartsBean());
	
		return mv;
	}

	@RequestMapping(value = "/Register", method = RequestMethod.POST)
	public ModelAndView loadServiceRegistrationPage(@ModelAttribute("carServiceObj") CarServiceBean car) {
		System.out.println("sd"+car.getCarType());
		ModelAndView modelAndView = new ModelAndView();
		
		Map<Integer,String> carMap=new HashMap<Integer,String>();
		carMap=carService.populatePartsDetails(car.getCarType());
			
			modelAndView.setViewName("serviceForm");
			modelAndView.addObject("message",carMap);

		return modelAndView;

	}
	

	@RequestMapping(value = "/processRegistrationPage", method = RequestMethod.POST)
	public ModelAndView processRegistrationForm(@Valid @ModelAttribute("carServiceObj")  CarServiceBean carServiceBean,
			BindingResult result) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println("id"+carServiceBean.getPartId()+"name"+carServiceBean.getCarNumber()+"use"+carServiceBean.getUserName());
		if (result.hasErrors()) {
			mv.setViewName("serviceForm");
		} else {
			CarServiceBean carServiceBean1 = carService.registerCarforService(carServiceBean);
			mv.setViewName("Success");
			mv.addObject("message", "Your service id is " + carServiceBean1.getServiceId()
					+ " and total repair cost will be " + carServiceBean1.getTotalRepairCost());
		}
		return mv;
	}
	@RequestMapping(value = "/LoadReport", method = RequestMethod.GET)
	//public List<CarServiceBean> processReport(@ModelAttribute("carServiceObj") ModelMap map) throws Exception
	public ModelAndView processReport(@ModelAttribute("carServiceObj") CarServiceBean bean) throws Exception
	{
		ModelAndView modelAndView = new ModelAndView();
		List<CarServiceBean> list=new ArrayList<>();
		list=carService.getAllCarServiceDetails();
		modelAndView.setViewName("report");
		modelAndView.addObject("orderList",list);
		return modelAndView;
		
	}

	// Error Handler:
	@ExceptionHandler(value = Exception.class)
	public ModelAndView handleAllExceptions(Exception exception) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("GeneralizedExceptionHandlerPage");
		modelAndView.addObject("message", exception.getMessage());
		// modelAndView.addObject("exception", exception);
		return modelAndView;
	}

}
