package com.service.spring;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.service.spring.domain.MyProduct;

public class myBatisFrameworkUnitTest1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
			// 1. 설정문서를 DIContainer가 읽어들여야 한다.
			Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
			
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
			
			SqlSession session = factory.openSession();
			
			MyProduct vo = new MyProduct("통돌이 세탁기","대우",500000);
			
			session.insert("ns.sql.MyProduct.addProduct",vo);
			session.commit();
			
			
	}

}
