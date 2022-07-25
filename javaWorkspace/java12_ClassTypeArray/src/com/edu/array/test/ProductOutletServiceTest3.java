package com.edu.array.test;

import com.edu.array.service.ProductOutletService;
import com.edu.array.vo.Customer;
import com.edu.array.vo.Product;

// 프로덕트 서비스 + 프로덕트 클래스를 테스트하는 

public class ProductOutletServiceTest3 {

	public static void main(String[] args) {
		
		Product[] pros1 = {
				new Product("신라면", 12000, 5, "농심"),
				new Product("새우깡", 1000, 2, "농심"),
				new Product("옥시크린", 32000, 1, "C3"),
				new Product("삼다수", 8000, 10, "제주")
		};
		
		Product[] pros2 = {
				new Product("안성탕면", 22000, 5, "농심"),
				new Product("칭따오", 500000, 50, "따오"),
				new Product("Terra", 2200, 3, "부산은행")
		};
		
		Customer[ ] custs = {
				new Customer(111, "구자경", "역삼동"),
				new Customer(222, "염미정", "산포시")
		};
		
		//각각의 고객과 상품들을 Hasing
		custs[0].buyProducts(pros2); // 구자경씨
		custs[1].buyProducts(pros1); // 염미정씨
		
		ProductOutletService service = new ProductOutletService();
		
		///// 아래에서는 서비스의 기능을 하나씩 호출합니다. //////
		// 1번
		
		Product[] newpro = service.getProducts(custs[0]);
		
		for(Product pro : newpro) {
			System.out.println(pro.getDetails());
		}
		
		// 2번
		String[] newString = service.getAllProductMaker(custs[0]);

		for(String str : newString) {
			System.out.println(str);
		}
		
		
		// 3번
		Customer newCust = service.findCustomerBySsn(custs, 111);
		
		System.out.println(newCust.customerInfo());
		
		
		// 4번
		Customer[] newCusts = service.findCustomerByAddress(custs, "역삼동");
		
		for(Customer tempCust : newCusts) {
			if(tempCust==null)	continue;
			System.out.println(tempCust.customerInfo());
		}
		
		// 5번
		
		System.out.println(service.getMaxPriceProduct(custs[1]));
		
		
		// 6번
		Product[] newPro = service.getMorePriceProducts(custs[1], 10000);
				
		for(Product tempPro : newPro) {
			if(tempPro==null)	continue;
			System.out.println(tempPro.getDetails());
		}
		
		System.out.println("===========7번===============");
		// 7번
		
		Product[] newPro2 = service.getMorePriceProducts(custs, 10000);
		
		for(Product tempPro : newPro2) {
			if(tempPro==null)	continue;
			System.out.println(tempPro.getDetails());
		}
		
		
		
		
		
		
		
	}

}
 