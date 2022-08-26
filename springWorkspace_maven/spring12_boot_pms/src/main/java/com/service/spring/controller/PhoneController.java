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
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.spring.domain.Phone;
import com.service.spring.domain.UserInfo;
import com.service.spring.model.PhoneService;

@Controller
public class PhoneController {
	
	@Autowired
	private PhoneService phoneService;
	
	@GetMapping("regPhone.do")
	public String getRegPhone(Model model) {
		
		model.addAttribute("title","�ڵ��� ���� ~~~ �ڵ��� ��� ��/");
		
		return "PhoneReg";
	}
	
	@PostMapping("savePhone.do") // select�� ������ insert...delete...update�� ��� ����Ʈ..
	public String doRegPhone(Phone phone,Model model) {
		
		try {
			phoneService.insert(phone);//���� ������
			model.addAttribute("title", "�ڵ��� ���� - �ڵ��� ���� ����");
			return "Result";
			
		}catch(Exception e) {
			// ���� ������
			System.out.println(e);
			model.addAttribute("title", "�ڵ��� ���� - �ڵ��� ���� ����");
			return "Error";
		}
		
	}
	
	@GetMapping("searchPhone.do")
	public String doList(Model model) {
		try {
			model.addAttribute("phones", phoneService.select());
			model.addAttribute("title", "�ڵ��� ���� - �ڵ��� ���� ��� �ҷ����� ����");
			return "PhoneList";
		}catch(Exception e) {
			
			model.addAttribute("title", "�ڵ��� ���� - �ڵ��� ���� ��� �ҷ����� ����");
			model.addAttribute("message", "�ڵ��� ���� - �ڵ��� ���� ��� �ҷ����� ����");
			return "Error";
		}
	}
	
	@GetMapping("detail.do")
	public String doDetail(Phone phone, Model model) {
		
		try {
			model.addAttribute("phone", phoneService.select(phone));
			model.addAttribute("title", "�ڵ��� ���� - �ڵ��� ����ȸ");
			return "PhoneView";
		}catch(Exception e) {
			model.addAttribute("title", "�ڵ��� ���� - �ڵ��� �� ��ȸ �ҷ����� ����");
			model.addAttribute("message", "�ڵ��� ���� - �ڵ��� �� ��ȸ �ҷ����� ����");
			return "Error";
		}
		
		
	}
	
	
	@PostMapping("deleteAjax.do")
	@ResponseBody
	public String doAjaxDelete(@RequestParam List<String> num, Model model) {
		List<String> temp = new ArrayList<String>();
		try {
			for(String n : num) temp.add(n);
			
			phoneService.delete(temp);
			return "JsonView";
		}catch(Exception e) {
			model.addAttribute("title", "�ڵ��� ���� - ����");
			model.addAttribute("message", "�ڵ��� ���� - ����");
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
			model.addAttribute("title", "�ڵ��� ���� - ����");
			model.addAttribute("message", "ȸ�� �α��� �� ���� �߻�...");
			return "Error";
		}
	}
	

}
