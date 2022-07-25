package com.edu.array.service;

import com.edu.array.vo.Product;

/*
 * Product들을 handling하는 서비스 클래스
 * 기능들만 모아 놓는 것
 * 1)모든 사웊ㅁ들의 maker를 출력하는 기능
 * 2) 상품들의 총 금액을 리턴하는 기능
 * 3) 특정금액 이상의 상품들을 리턴하는 기능
 * 4) 동일한 회사의 제품들만 리턴하는 기능
 * 5) 구입한 상품들의 평균가를 리턴하는 기능(수량 포함)
 * 
 *  기능 5개 선언부를 중요하게 생각함
 *  5개의 펑션 정의 선언부를 먼저 뽑아
 *  그러고나서 구현부 작성
 *  
 */
public class ProductService {
	
//	private Product[] products;
//	
//	public ProductService(Product[] products) {
//		super();
//		this.products = products;
//	}

	public void printAllMaker(Product[] products) {
		for(Product returnPro: products) {
			System.out.println(returnPro.getMaker());
		}
	}
	
	public int getAllPrice(Product[] products) {
		int amount = 0;
		for(Product returnPro: products) {
			amount += returnPro.getPrice()*returnPro.getQuantity();
		}
		return amount;
	}
	/*
	 * Method Overloading
	 * ::
	 * 하는 일은 같지만
	 * 처리하는 데이터를 달리할때 사용하는 기법
	 * 
	 * ::
	 * 1. 메소드 이름은 같아야한다.
	 * 2. 매개변수는 반드시 달라야한다(순서, 갯수, 타입)
	 * 3. 원소의 리턴타입은 상관 없다.
	 * 
	 * ::
	 * public Member[ ] searchMember(String name)
	 * public Member[ ] searchMember(String address, String name)
	 * 
	 * public Member[ ] searchMemberByName(String name)
	 * public Mmeber[ ] searchMemberByAge(int Age)
	 * 
	 * 
	 * public Member[ ] searchMember(String name)
	 * 오버로딩의 한계점, 메소드 갯수를 줄일 순 없다
	 * 오버로딩을 적극적으로 사용해서 코드의 일관성을 확보할 필요가 있음!
	 */
	
	
	
	public Product[] getOver10e4Products(Product[] products, int price) {
		Product[] temp = new Product[products.length];
		int index = 0;
		for(Product returnPro: products) {
			if(returnPro.getPrice()>=10000) {
				temp[index++] = returnPro;
			}
		}
		return temp;
	}
	
	
	public Product[] getSameMakerProducts(Product[] products, String Maker) {
		Product[] temp = new Product[products.length];
		int index = 0;
		for(Product returnPro: products) {
			if(returnPro.getMaker().equals(Maker)) {
				temp[index++] = returnPro;
			}
		}
		
		return temp;
	}
	
	public int getAveragePrice(Product[] products)
	{
		return getAllPrice(products)/products.length;
	}
	
	

}
