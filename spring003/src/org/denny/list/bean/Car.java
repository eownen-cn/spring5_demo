package org.denny.list.bean;

public class Car implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id ;
	private String brand ;
	private double price ;
	public final Integer getId() {
		return id;
	}
	public final void setId(Integer id) {
		this.id = id;
	}
	public final String getBrand() {
		return brand;
	}
	public final void setBrand(String brand) {
		this.brand = brand;
	}
	public final double getPrice() {
		return price;
	}
	public final void setPrice(double price) {
		this.price = price;
	}
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Car(Integer id, String brand, double price) {
		super();
		this.id = id;
		this.brand = brand;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Car [brand=" + brand + ", price=" + price + "]";
	}
	
}
