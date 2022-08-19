package com.service.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {

	//���� �Էµ� ���� Controller�� �Ѿ�ö� �ڵ����� ���ε� ��...
	@RequestMapping("form.do")
	public ModelAndView form(HttpServletRequest req, HttpServletResponse res, String name, String addr) {
		
		/*
		 * ���� �޾Ƽ�
		 * VO ����
		 * ���� �޾Ƽ�
		 * service.registerform(); --> dao.register(); -> sqlSession.insert("mapper.addRegister", vo);
		 * ModelAndView ����
		 * 
		 */
		
		
		return new ModelAndView("form_result","info",name+"���� ��� ���� "+addr);
	}
	
}
