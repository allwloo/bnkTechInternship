package util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//SqlSessionFactory 까지 받아오는 로직을 여기서 작성....

public class FactoryService {
	private static SqlSessionFactory factory;
	
	static {
		//2. 지금부터 mybatis 사용 호출...
				try {
					Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
					factory =  new SqlSessionFactoryBuilder().build(r);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}// static
	
	public static SqlSessionFactory getFactory() {
		return factory;
	}
	
}
