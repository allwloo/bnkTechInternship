package com.service.spring.model;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.MyProduct;

@Repository
public class MyProductDAOImpl implements MyProductDAO {

	private final static String NS = "ns.sql.MyProduct.";
	
	@Autowired
	private SqlSession sqlSession;
	
	
	@Override
	public int addProduct(MyProduct vo) throws Exception {
		return sqlSession.insert(NS+"addProduct",vo);
	}

}
