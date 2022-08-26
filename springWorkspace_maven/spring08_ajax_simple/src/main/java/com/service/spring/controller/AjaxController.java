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
	}// internalviewresolver... 이런거랑 redirect는 상관 없다 그래서 확장자 suffix prefix 이런거랑 상관없음
	
	@RequestMapping("synchro")
	public String synchro(Model model) {
		System.out.println("context path request..../....");
		
		model.addAttribute("info","hihiwawawawahihihihi");
		return "synchro_result";
	}
	
	@RequestMapping("asynch")
	public String asynch(Model model) {
		System.out.println("비동기당");
		
		model.addAttribute("person",new Person("구자경", "산묘시"));
		
		return "jsonView";
	}
}
