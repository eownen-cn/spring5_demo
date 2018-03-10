package spring.hibernate.entity;

import java.io.Serializable;

public class Computer implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String comid ;
	
	private String comName ;

	public String getComid() {
		return comid;
	}

	public void setComid(String comid) {
		this.comid = comid;
	}

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	public Computer() {
		super();
	}

	public Computer(String comName) {
		this.comName = comName;
	}

	@Override
	public String toString() {
		return "Computer [comid=" + comid + ", comName=" + comName + "]";
	}
	
	
}
