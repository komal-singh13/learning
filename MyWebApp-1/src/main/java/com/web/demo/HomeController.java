package com.web.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("myhome")
	public ModelAndView home(Customer customer) {
		
		ModelAndView mv= new ModelAndView();
		mv.addObject("cust", customer);
		mv.setViewName("home");
		return mv;
	}
}
