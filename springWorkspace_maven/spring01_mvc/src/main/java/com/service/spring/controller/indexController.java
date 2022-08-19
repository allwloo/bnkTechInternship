package com.service.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class indexController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * 폼값 받아서
		 * 2. vo 생성
		 * 3. DAO 주입
		 * 4. DAO 메소드 호출....
		 * 6. modelandview 리턴
		 */
		// TODO Auto-generated method stub
		return new ModelAndView("result", "message", "Hello Spring!");
	}

}
