package broker.twotier.test;

import java.util.ArrayList;
import java.util.Vector;

import broker.twotier.dao.Database;
import broker.twotier.vo.SharesRec;
import broker.twotier.vo.StockRec;

public class DatabaseTest {

	public static void main(String[] args)throws Exception{
		
		ArrayList<StockRec> sh = new ArrayList<StockRec>();
		Vector<SharesRec> sr = new Vector<SharesRec>();
		
		try {
		Database db = new Database("127.0.0.1");
		db.deleteCustomer("777-777");
		
//		db.buyShares("111-111", "jdk", 100);
//		sr = db.getPortfolio("111-111");
//		sh = db.getAllStocks();
		
		//db.addCustomer(new CustomerRec("113-111", "하바리", "다산동"));
		//db.buyShares("111-111", "jdk", 50);
		}catch(Exception e) {
			//System.out.println(e);
		}finally{
			System.out.println("시스템 종료");
		}
		
		//db.deleteCustomer("777-777");
		//db.updateCustomer(new CustomerRec("777-777", "하바리", "약수동"));
		
		/*Vector<SharesRec> v = db.getPortfolio("777-777");
		for(SharesRec sr : v)System.out.println(v);*/
	}

}
