package servlet.controller;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bnk.model.Item;
import com.bnk.model.ItemDao;


public class ItemListController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/// 브라우저에 저장된 모든 쿠키정보를 받아오는 로직을 작성
		
		Cookie[] cs = request.getCookies();
		ArrayList<String> fruits = new ArrayList<>();
		
		if(cs!=null ) {
			for(Cookie c : cs) {
				// 이때 fruit사이에서 건너간 쿠키의 값만 받아오고 싶으면...?
				if(c.getName().startsWith("fruitshop")) fruits.add(c.getValue()); 
			}
		}
				
		request.setAttribute("fruits", fruits);
		
		ArrayList<Item> list=ItemDao.getInstance().getAllItem();
		System.out.println(list);
		request.setAttribute("list", list);
		return new ModelAndView("itemList.jsp");
	}
}
