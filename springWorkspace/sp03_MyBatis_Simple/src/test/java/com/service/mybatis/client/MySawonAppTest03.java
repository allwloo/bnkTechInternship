package com.service.mybatis.client;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.service.mybatis.vo.MySawon;

import util.FactoryService;

public class MySawonAppTest03 {

	public static void main(String[] args) throws Exception{
		
		SqlSessionFactory factory = FactoryService.getFactory();
		
		ArrayList<MySawon> vo2 = new ArrayList<>();
		
		//2. 지금부터 mybatis 사용 호출...
				Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
				
				//3. new SqlSessionFactory
				SqlSessionFactory factory =  new SqlSessionFactoryBuilder().build(r);
		
		//4. SqlSession
		SqlSession session = factory.openSession(); 
		
		//5. sql세션안에 쿼리문 실행하는 기능이 드렁있다.
		List<MySawon> list = session.selectList("sawonMapper.sawonList");
		
		for(MySawon v : list)
				System.out.println(v);
		
		session.commit();
		session.close();
		
	}

}
