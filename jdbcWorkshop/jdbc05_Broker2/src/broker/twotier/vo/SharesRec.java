package broker.twotier.vo;

/*
 * Shares 테이블의 정보를 담는 클래스
 * 누가....ssn
 * 어떤 주식을....symbol
 * 
 * 얼만큼.... 보유 quantity
 */

public class SharesRec {
	private String ssn;
	private String symbol;
	private int quantitiy;
	public SharesRec() {
		
	}
	
	public SharesRec(String ssn, String symbol, int quantitiy) {
		super();
		this.ssn = ssn;
		this.symbol = symbol;
		this.quantitiy = quantitiy;
		
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public int getQuantitiy() {
		return quantitiy;
	}
	public void setQuantitiy(int quantitiy) {
		this.quantitiy = quantitiy;
	}
	@Override
	public String toString() {
		return "SharesRec [ssn=" + ssn + ", symbol=" + symbol + ", quantitiy=" + quantitiy + "]";
	}

	public int getQuantity() {
		// TODO Auto-generated method stub
		return quantitiy;
	}
	
}
