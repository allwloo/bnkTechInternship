package com.service.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

@org.springframework.stereotype.Controller
public class MainController{ // POJO

	@RequestMapping("main.do")
	public ModelAndView main() {
		
		return new ModelAndView("main_view","info", "MainController, Annotation~~!");
	}
}
