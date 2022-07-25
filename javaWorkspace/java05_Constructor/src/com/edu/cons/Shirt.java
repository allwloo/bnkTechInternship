package com.edu.cons;

public class Shirt {
	public String brand;
	public boolean longSleeved;
	public char size;
	
	
	
	public Shirt() {
		super();
	}
	public String getBrand() {
		return brand;
	}
	public boolean isLongSleeved() {
		return longSleeved;
	}
	public Shirt(String brand, boolean longSleeved, char size) {
		super();
		this.brand = brand;
		this.longSleeved = longSleeved;
		this.size = size;
	}
	public char getSize() {
		return size;
	}
}
