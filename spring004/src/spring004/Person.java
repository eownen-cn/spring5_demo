package spring004;

import java.util.List;

public class Person implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private String name ;
	private List<Address> dressList ;
	private Car car ;
	public final String getName() {
		return name;
	}
	public final void setName(String name) {
		this.name = name;
	}
	public final List<Address> getDressList() {
		return dressList;
	}
	public final void setDressList(List<Address> dressList) {
		this.dressList = dressList;
	}
	public final Car getCar() {
		return car;
	}
	public final void setCar(Car car) {
		this.car = car;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", dressList=" + dressList + ", car="
				+ car + "]";
	}
	
}
