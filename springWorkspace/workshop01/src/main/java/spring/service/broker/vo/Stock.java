package spring.service.broker.vo;

public class Stock {
	
	private String symbol;
	private double price;
	
	Stock(){}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Stock(String symbol, double price) {
		super();
		this.symbol = symbol;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Stock [symbol=" + symbol + ", price=" + price + "]";
	}
	
	
	
	

}
