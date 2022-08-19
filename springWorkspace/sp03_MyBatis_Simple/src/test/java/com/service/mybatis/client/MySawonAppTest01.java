package com.service.mybatis.client;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.service.mybatis.vo.MySawon;

public class MySawonAppTest01 {

	public static void main(String[] args) throws Exception{
		//1. 폼으로부터 받은 값을 가지고 vo 생성....
		
		MySawon vo = new MySawon();
		
		vo.setId("aaa");
		vo.setPwd("777");
		vo.setName("아이유");
		vo.setAge(28);
		
		
		
		//2. 지금부터 mybatis 사용 호출...
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		//3. new SqlSessionFactory
		SqlSessionFactory factory =  new SqlSessionFactoryBuilder().build(r);
		
		//4. SqlSession
		SqlSession session = factory.openSession(); 
		
		//5. sql세션안에 쿼리문 실행하는 기능이 드렁있다.
		session.insert("sawonMapper.sawonAdd", vo);
		session.commit();
		session.close();
		
	}

}
