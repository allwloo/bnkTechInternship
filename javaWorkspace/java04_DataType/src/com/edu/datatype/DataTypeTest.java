package com.edu.datatype;
/*
 * madeCompany  --- "동신사"
 * color --- W
 * price --- 300.23
 * scratch --- 있다 / 없음
 * material --- 합판과 알루미늄
 * buyDate   --- 2022-07-19 (class MyDate)
 * 
 * set() / get()
 */
class MyDate{
	int year;
	int month;
	int day;	
	public void setDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;		
	}
	public String getDate() {
		return year+"-"+month+"-"+day;
	}
}
class WhiteBoard{
	//필드는 기본값을 가진다...
	//로컬 변수는 기본값이 없다 그래서 사용하기 전 반드시 초기화해야 한다.
	String madeCompany;
	char color;
	float price;
	boolean scratch;
	String material;
	MyDate buyDate;
	
	public void setWhiteBoard(String madeCompany,
							  char color,
							  float price,
							  boolean scratch,
							  String material,
							  MyDate buyDate) {
		this.madeCompany = madeCompany;
		this.color = color;
		this.price = price;
		this.scratch = scratch;
		this.material = material;
		this.buyDate = buyDate;
	}	
	public String getWhiteBoard() {
		return  madeCompany+"\t"
			  + color+"\t"
			  + price+"\t"
			  + scratch+"\t"
			  + material+"\t"
			  + buyDate;
	}
}
public class DataTypeTest {
	public static void main(String[] args) {
		WhiteBoard wb = new WhiteBoard();
		System.out.println(wb.getWhiteBoard());
		
		wb.setWhiteBoard("동신사", 'W', 34.99f, true, "합판", new MyDate());
		
	}

}