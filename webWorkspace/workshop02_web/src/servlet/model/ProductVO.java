package servlet.model;

public class ProductVO {
	private int pronum;
	private String name;
	private String price;
	private String detail;

	public ProductVO() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public ProductVO(int pronum, String name, String price, String detail) {
		super();
		this.pronum = pronum;
		this.name = name;
		this.price = price;
		this.detail = detail;
	}
	public ProductVO(String name, String price, String detail) {
		super();
		this.name = name;
		this.price = price;
		this.detail = detail;
	}
	public int getPronum() {
		return pronum;
	}
	public void setPronum(int pronum) {
		this.pronum = pronum;
	}
	@Override
	public String toString() {
		return "ProductVO [pronum=" + pronum + ", name=" + name + ", price=" + price + ", detail=" + detail + "]";
	}
	
	

}
