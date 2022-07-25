package com.edu.array.service;

import com.edu.array.vo.Customer;
import com.edu.array.vo.Product;

public class ProductOutletService {
	//1. 특정 고객이 구입한 상품을 리턴
	public Product[] getProducts(Customer cust) {
		return cust.getProducts();
	}
	
	//2. 특정 고객이 구입한 상품의 maker들만 리턴..
	public String[] getAllProductMaker(Customer cust) {
		String[] temp = new String[cust.getProducts().length];
		Product[] newpro = getProducts(cust);
		
		int index = 0;
		
		for(Product pro : newpro) {
			temp[index++] = pro.getMaker();
		}
		
		return temp;
	}
	// 오버로딩 해보기
	//3. 모든 고객들 중에서 특정한 고객을 검색하는 기능 search, find
	//ssn으로 검색
	public Customer findCustomerBySsn(Customer[] custs, int ssn) {
		Customer customer = null;
		
		for(Customer tempCust : custs) {
			if(tempCust.getSsn()==ssn)	customer = tempCust;
		}
		
		return customer;
	}
	
	//4. 특정한 동내에 살고있는 고객들을 검색
	public Customer[] findCustomerByAddress(Customer[] custs, String address) {
		Customer[] temp = new Customer[custs.length];
		
		int index = 0;
		for(Customer tempCust : custs) {
			if(tempCust.getAddress().equals(address)) {
				temp[index++] = tempCust;
			}
		}
		
		return temp;
	}
	
	//5. 특정 고객이 구입한 물건들 중에서 최고가에 해당하는 물건의 가격을 리턴...
	// getProducts를 받아와서 최고가 포문 돌리기
	public int getMaxPriceProduct(Customer cust) {
		int maxPrice = 0;
		Product[] temp = cust.getProducts();
		
		for(Product temppro : temp) {
			if(temppro.getPrice()>maxPrice) maxPrice = temppro.getPrice();
		}
		
		
		return maxPrice;
	}
	
	//6. 특정 고객이 구입한 물건 중 특정 가격 이상이 되는 제품들을 리턴..
	public Product[] getMorePriceProducts(Customer cust, int price) {
		Product[] temp = cust.getProducts();
		Product[] temp2 = new Product[temp.length];
		
		int index = 0;
		
		for(Product tempPro : temp)
			if(tempPro.getPrice()>price)
				temp2[index++] = tempPro;
		
		
		
		return temp2;
	}
	
	//7. 모든 고객이 구입한 물건 중 특정 가격 이상이 되는 제품들을 리턴..
		public Product[] getMorePriceProducts(Customer[] custs, int price) {
			int len = 0;
			int index = 0;
			for(Customer c : custs) 
				len += c.getProducts().length;
			
			Product[] temp = new Product[len];
	
			for(Customer c : custs)
				for(Product tempPro : c.getProducts())
					temp[index++] = tempPro;

			
			return temp;
		}
	

}
