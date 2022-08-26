package com.service.spring;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.service.spring.domain.MyProduct;

public class myBatisFrameworkUnitTest1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
			// 1. ���������� DIContainer�� �о�鿩�� �Ѵ�.
			Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
			
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
			
			SqlSession session = factory.openSession();
			
			MyProduct vo = new MyProduct("1234r","1234",500000);
			
			session.insert("ns.sql.MyProduct.addProduct",vo);
			session.commit();
			
			List<MyProduct> list = session.selectList("ns.sql.MyProduct.findProductByName","세탁기");
			
			System.out.println(list);
			
			
			
	}

}
