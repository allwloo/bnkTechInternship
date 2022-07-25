package com.edu.array.test;

import com.edu.array.service.ProductService;
import com.edu.array.vo.Product;

// 프로덕트 서비스 + 프로덕트 클래스를 테스트하는 

public class ProductServiceTest2 {

	public static void main(String[] args) {
		
		Product[] pros = {
				new Product("신라면", 12000, 5, "농심"),
				new Product("새우깡", 1000, 2, "농심"),
				new Product("옥시크린", 32000, 1, "C3"),
				new Product("삼다수", 8000, 10, "제주")
		};
		
		
		
		ProductService ps = new ProductService();
		
		ps.printAllMaker(pros);
		System.out.println(ps.getAllPrice(pros));
		
		Product[] pros2 = new Product[pros.length];
		pros2 = ps.getOver10e4Products(pros, 10000);
		
		for(Product returnPro: pros2) {
			if(returnPro == null)
				continue;
			System.out.println(returnPro.getDetails());
		}
		
		
		Product[] pro3 = ps.getSameMakerProducts(pros, "농심");
		
		for(Product returnPro: pro3) {
			if(returnPro == null)
				continue;
			System.out.println(returnPro.getDetails());
		}
		
		
		System.out.println(ps.getAveragePrice(pros));
	}
	
	//Service라는 참조변수를 이용해서 구현하신 기능을 하나씩 호출합니다.
}
 