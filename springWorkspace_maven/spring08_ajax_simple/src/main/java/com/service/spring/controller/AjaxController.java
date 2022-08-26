package com.service.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.spring.domain.Person;

@Controller
public class AjaxController {

	@RequestMapping("/")
	public String index() {
		System.out.println("context path request..../....");
		return "redirect:index.jsp";
	}// internalviewresolver... �̷��Ŷ� redirect�� ��� ���� �׷��� Ȯ���� suffix prefix �̷��Ŷ� �������
	
	@RequestMapping("synchro")
	public String synchro(Model model) {
		System.out.println("context path request..../....");
		
		model.addAttribute("info","hihiwawawawahihihihi");
		return "synchro_result";
	}
	
	@RequestMapping("asynch")
	public String asynch(Model model) {
		System.out.println("�񵿱��");
		
		model.addAttribute("person",new Person("���ڰ�", "�깦��"));
		
		return "jsonView";
	}
}
