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
					// 1. ���������� DIContainer�� �о�鿩�� �Ѵ�.
					Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
					
					SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
					
					SqlSession session = factory.openSession();
					
					MyProduct vo = new MyProduct("������ ��Ź��","�Ｚ",380000);
					
					session.insert("ns.sql.MyProduct.addProduct",vo);
					session.commit();
					System.out.println("�Ϸ� ! ");
	}

}
