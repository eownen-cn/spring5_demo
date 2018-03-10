package org.denny.bean;

import org.springframework.beans.factory.annotation.Autowired;

public class People implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id ;
	private String name ;
	private Address address ;
	private Car car ;
	public People() {
		super();
		// TODO Auto-generated constructor stub
	}
	public People(String name, Address address, Car car) {
		super();
		this.name = name;
		this.address = address;
		this.car = car;
	}
	
	public final Integer getId() {
		return id;
	}
	public final void setId(Integer id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "People [name=" + name + ", address=" + address
				+ ", car=" + car + "]";
	}
	public final String getName() {
		return name;
	}
	public final void setName(String name) {
		this.name = name;
	}
	public final Address getAddress() {
		return address;
	}
	public final void setAddress(Address address) {
		this.address = address;
	}
	public final Car getCar() {
		return car;
	}
	public final void setCar(Car car) {
		this.car = car;
	}
	
}
