package servlet.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bnk.model.Item;
import com.bnk.model.ItemDao;


public class ItemViewController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int itemnum = Integer.parseInt(request.getParameter("itemnumber"));
		
		//count증가...로직을 함께 작성
		boolean result=ItemDao.getInstance().updateRecordCount(itemnum);
		System.out.println("count update? "+result);
		
		Item item=ItemDao.getInstance().getItem(itemnum);
		System.out.println("getItem()? "+item);
		
		// 상세보기로 들어간거잖아 그치 이때 오늘 본 상품이 무엇인지를 쿠키에 담는다...
		Cookie c1 = new Cookie("fruitshop"+itemnum,item.getUrl());
		c1.setMaxAge(24*60*60);
		response.addCookie(c1);
	
		
		request.setAttribute("item", item);
		return new ModelAndView("itemView.jsp");
	}

}









