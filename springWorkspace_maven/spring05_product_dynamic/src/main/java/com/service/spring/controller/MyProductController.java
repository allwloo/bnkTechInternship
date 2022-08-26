package com.service.spring.controller;

import java.util.List;

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
		System.out.println("ss: "+vo+"\n");
		myProductService.addProduct(vo);
		System.out.println("ss: "+vo+"\n");
		return new ModelAndView("insert_result", "info", vo);
	}
	
	@RequestMapping("myProductSearch.do")
	public ModelAndView search(String command, String word) throws Exception{
		
		List<MyProduct> list = null;
		String viewName = "find_result";

		if(command.equals("findProducts")){
			list = myProductService.findProductByName(word);
			viewName = "find_result";
		}else if(command.contentEquals("findProducts2")) {
			list = myProductService.findProductByMaker(word);
			viewName = "find_result";
		}else {
			list = myProductService.findProducts();
			viewName = "find_result";
		}
		return new ModelAndView(viewName,"list",list);
		
	}
}
