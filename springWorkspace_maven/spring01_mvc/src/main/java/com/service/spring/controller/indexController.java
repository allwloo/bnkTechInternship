package com.service.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class indexController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * ���� �޾Ƽ�
		 * 2. vo ����
		 * 3. DAO ����
		 * 4. DAO �޼ҵ� ȣ��....
		 * 6. modelandview ����
		 */
		// TODO Auto-generated method stub
		return new ModelAndView("result", "message", "Hello Spring!");
	}

}
