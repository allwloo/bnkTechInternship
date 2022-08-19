package com.service.spring;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.service.spring.domain.MyProduct;

public class myBatisFrameworkJUnitTest2 {

	@Test
	public void unit() throws Exception{
		// TODO Auto-generated method stub
					// 1. 설정문서를 DIContainer가 읽어들여야 한다.
					Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
					
					SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
					
					SqlSession session = factory.openSession();
					
					MyProduct vo = new MyProduct("공기방울 세탁기","삼성",380000);
					
					session.insert("ns.sql.MyProduct.addProduct",vo);
					session.commit();
					System.out.println("완료 ! ");
	}

}
