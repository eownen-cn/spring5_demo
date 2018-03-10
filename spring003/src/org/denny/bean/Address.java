package org.denny.bean;

public class Address implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String id ;
	private String city ;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(String id, String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Address [city=" + city + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}
