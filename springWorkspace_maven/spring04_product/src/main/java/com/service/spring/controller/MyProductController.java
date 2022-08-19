package com.service.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.domain.MyProduct;
import com.service.spring.model.MyProductService;

@Controller
public class MyProductController {

	@Autowired
	private MyProductService myProductService;
	
	@RequestMapping("myProduct.do")
	public ModelAndView insert(MyProduct vo) throws Exception{
		/*
		 * String name = request.getParameter("name");
		 * String maker = request.getParameter("maker");
		 * Int price = Interger.parseInt(request.getParameter("price"));
		 * 
		 * MyProduct vo = new MyProduct(name, maker, price);
		 */
		System.out.println("디비 입력 전: "+vo+"\n");
		myProductService.addProduct(vo);
		System.out.println("디비 입력 후: "+vo+"\n");
		return new ModelAndView("insert_result", "info", vo);
	}
}
