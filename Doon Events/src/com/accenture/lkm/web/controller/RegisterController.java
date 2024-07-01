package com.accenture.lkm.web.controller;

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
import org.springframework.web.servlet.ModelAndView;
import com.accenture.lkm.business.bean.EventBean;
import com.accenture.lkm.business.bean.RegisterBean;
import com.accenture.lkm.service.InvalidAgeException;
import com.accenture.lkm.service.RegisterService;

@Controller
public class RegisterController {

	@Autowired
	private RegisterService service;

	@RequestMapping(value = "displayRegisterForm.htm")
	public ModelAndView displayRegisterForm(ModelMap map) {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("register");
		mv.addObject("registerBean", new RegisterBean());

		return mv;
	}

	@RequestMapping(value = "registerForEvent.htm")
	public ModelAndView registerForEvent(@ModelAttribute("registerBean") @Valid RegisterBean bean, BindingResult errors)
			throws InvalidAgeException {

		ModelAndView mv = new ModelAndView();

		if (errors.hasErrors()) {
			mv.setViewName("register");
		} else {

			int id = service.registerForEvent(bean);
			mv.setViewName("register");
			mv.addObject("message", "Registration Successful, Registration Id = " + id);
		}

		return mv;
	}

	@ModelAttribute("eventList")
	public Map<String, String> populateEventList() {

		List<EventBean> eblist = service.getEventDetails();

		Map<String, String> m = new HashMap<String, String>();
		for (EventBean eb : eblist) {
			m.put(eb.getEventId(), eb.getEventName());
		}

		return m;
	}

	/*
	 * @ExceptionHandler(value = Exception.class) public ModelAndView
	 * handleAllExceptions(Exception exception) {
	 * 
	 * ModelAndView mv = new ModelAndView(); mv.setViewName("register");
	 * mv.addObject("error", exception.getMessage());
	 * 
	 * return mv; }
	 */

}