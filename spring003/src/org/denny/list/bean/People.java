package org.denny.list.bean;

import java.util.List;


public class People implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id ;
	private String name ;
	private Address address ;
	private List<Car> carList ;
	
	public final List<Car> getCarList() {
		return carList;
	}
	public final void setCarList(List<Car> carList) {
		this.carList = carList;
	}
	public People() {
		super();
		// TODO Auto-generated constructor stub
	}
	public People(String name, Address address) {
		super();
		this.name = name;
		this.address = address;
	}
	
	public final Integer getId() {
		return id;
	}
	public final void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "People [id=" + id + ", name=" + name + ", address=" + address
				+ ", carList=" + carList + "]";
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
	
}
