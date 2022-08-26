package com.service.spring.model;

import java.util.List;

import com.service.spring.domain.MyProduct;

public interface MyProductDAO {
	
	
	int addProduct(MyProduct vo) throws Exception;
	
	List<MyProduct> findProductByName(String name) throws Exception;
	List<MyProduct> findProductByMaker(String name) throws Exception;
	List<MyProduct> findProducts(String name) throws Exception;
	
}