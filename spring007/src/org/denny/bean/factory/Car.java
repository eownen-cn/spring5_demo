package org.denny.bean.factory;

public class Car implements java.io.Serializable{
	private static final long serialVersionUID = -3191039186504518948L;
	private String name ;
	private double price ;
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Car(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Car [name=" + name + ", price=" + price + "]";
	}
	
}
