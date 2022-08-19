package com.service.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {

	//폼에 입력된 값이 Controller로 넘어올때 자동으로 바인딩 됌...
	@RequestMapping("form.do")
	public ModelAndView form(HttpServletRequest req, HttpServletResponse res, String name, String addr) {
		
		/*
		 * 폼값 받아서
		 * VO 생성
		 * 서비스 받아서
		 * service.registerform(); --> dao.register(); -> sqlSession.insert("mapper.addRegister", vo);
		 * ModelAndView 생성
		 * 
		 */
		
		
		return new ModelAndView("form_result","info",name+"님이 사는 곳은 "+addr);
	}
	
}
