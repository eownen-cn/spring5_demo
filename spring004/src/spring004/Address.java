package spring004;

public class Address implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private String city ;
	private String street ;
	public final String getCity() {
		return city;
	}
	public final void setCity(String city) {
		this.city = city;
	}
	public final String getStreet() {
		return street;
	}
	public final void setStreet(String street) {
		this.street = street;
	}
	@Override
	public String toString() {
		return "Address [city=" + city + ", street=" + street + "]";
	}
	
}
