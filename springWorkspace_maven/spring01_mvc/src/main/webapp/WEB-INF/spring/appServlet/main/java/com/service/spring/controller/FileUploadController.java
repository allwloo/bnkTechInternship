package com.service.spring.controller;

import java.io.File;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.model.UploadDataVO;

@Controller
public class FileUploadController {
	
	@RequestMapping("fileupload.do")
	public ModelAndView upload(UploadDataVO vo, HttpServletRequest request) throws Exception {
		
		System.out.println(vo.getUserName());
		
		MultipartFile mf = vo.getUploadFile();
		
		if(!mf.isEmpty()) {
			System.out.println(mf.getSize());
			
			System.out.println(mf.getOriginalFilename());
			
			
			System.out.println("=================="+mf.getName());
		}
		
		//3. ���ε��� ������ �츮�� ������ ��ο� �̵�
		// contextpath �޾ƿ���
		String root = request.getSession().getServletContext().getRealPath("/");
		
		System.out.println("root "+root);
		
		String path = root+"\\upload\\";
		
		//4. ������ ���� path �ȿ� �̵��ϰ��� �ϴ� ���� ����
		File copyFile = new File(path+mf.getOriginalFilename());
		
		//5. ������  copyfile �̵���Ŵ.
		mf.transferTo(copyFile); // �츮�� ���ε��� ������ ī�Ǻ��� �ش��ο� ����
		System.out.println("path "+path);
		
		
		
		return new ModelAndView("upload_result","uploadFile",mf.getOriginalFilename());
	}
	
	
	@RequestMapping("fileDown.do")
	public ModelAndView filedown(String filename, HttpServletRequest request) {
		
		String root = request.getSession().getServletContext().getRealPath("/");
		String path = root+"\\upload\\";
		
		
		HashMap map = new HashMap();
		
		map.put("path", path);
		
		System.out.println("filename "+filename);
		return new ModelAndView("downloadView",map);
	}
	
}

