package com.service.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.service.spring.domain.Phone;
import com.service.spring.domain.UserInfo;
import com.service.spring.model.PhoneService;

@Controller
public class PhoneController {
	
	@Autowired
	private PhoneService phoneService;
	
	@GetMapping("regPhone.do")
	public String getRegPhone(Model model) {
		
		model.addAttribute("title","핸드폰 관리 ~~~ 핸드폰 등록 폼/");
		
		return "PhoneReg";
	}
	
	@PostMapping("savePhone.do") // select를 제외한 insert...delete...update를 모두 포스트..
	public String doRegPhone(Phone phone,Model model) {
		
		try {
			phoneService.insert(phone);//성공 페이지
			model.addAttribute("title", "핸드폰 관리 - 핸드폰 저장 성공");
			return "Result";
			
		}catch(Exception e) {
			// 에러 페이지
			System.out.println(e);
			model.addAttribute("title", "핸드폰 관리 - 핸드폰 저장 실패");
			return "Error";
		}
		
	}
	
	@GetMapping("searchPhone.do")
	public String doList(Model model) {
		try {
			model.addAttribute("phones", phoneService.select());
			model.addAttribute("title", "핸드폰 관리 - 핸드폰 저장 목록 불러오기 성공");
			return "PhoneList";
		}catch(Exception e) {
			
			model.addAttribute("title", "핸드폰 관리 - 핸드폰 저장 목록 불러오기 실패");
			model.addAttribute("message", "핸드폰 관리 - 핸드폰 저장 목록 불러오기 실패");
			return "Error";
		}
	}
	
	@GetMapping("detail.do")
	public String doDetail(Phone phone, Model model) {
		
		try {
			model.addAttribute("phone", phoneService.select(phone));
			model.addAttribute("title", "핸드폰 관리 - 핸드폰 상세조회");
			return "PhoneView";
		}catch(Exception e) {
			model.addAttribute("title", "핸드폰 관리 - 핸드폰 상세 조회 불러오기 실패");
			model.addAttribute("message", "핸드폰 관리 - 핸드폰 상세 조회 불러오기 실패");
			return "Error";
		}
		
		
	}
	
	
	@PostMapping("deleteAjax.do")
	public String doAjaxDelete(@RequestParam List<String> num, Model model) {
		List<String> temp = new ArrayList<String>();
		try {
			for(String n : num) temp.add(n);
			
			phoneService.delete(temp);
			return "JsonView";
		}catch(Exception e) {
			model.addAttribute("title", "핸드폰 관리 - 에러");
			model.addAttribute("message", "핸드폰 관리 - 에러");
			return "Error";
		}
		
	
	}
	
	/// login
	
	@GetMapping("login.do")
	public String getLoginForm() {
		return "Login";
	}
	
	@PostMapping("login.do")
	public String doLogin(UserInfo user, Model model, HttpSession session) {
		try {
			UserInfo selected = phoneService.select(user);
		
			if(selected!=null) {
				session.setAttribute("loginUser", selected);
				return "redirect:searchPhone.do";
			}
			else {
				return "Login";
			}
		}catch(Exception e){
			System.out.println(e);
			model.addAttribute("title", "핸드폰 관리 - 에러");
			model.addAttribute("message", "회원 로그인 중 에러 발생...");
			return "Error";
		}
	}
	

}
