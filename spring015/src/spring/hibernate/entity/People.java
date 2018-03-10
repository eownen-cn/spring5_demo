package spring.hibernate.entity;

import java.io.Serializable;
import java.util.Set;

public class People implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String peoid ;
	
	private String pname ;
	
	private Set<Computer> comList ;
	
	public final String getPeoid() {
		return peoid;
	}
	public final void setPeoid(String peoid) {
		this.peoid = peoid;
	}
	public final String getPname() {
		return pname;
	}
	public final void setPname(String pname) {
		this.pname = pname;
	}
	public final Set<Computer> getComList() {
		return comList;
	}
	public final void setComList(Set<Computer> comList) {
		this.comList = comList;
	}
	public People() {
		super();
		// TODO Auto-generated constructor stub
	}
	public People(String pname) {
		this.pname = pname;
	}
	@Override
	public String toString() {
		return "People [peoid=" + peoid + ", pname=" + pname + ", comList=" + comList + "]";
	}
	
}
