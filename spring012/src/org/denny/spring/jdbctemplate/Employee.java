package org.denny.spring.jdbctemplate;

public class Employee implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer empno ;
	private String email ;
	private String deptno ;
	
	public Employee() {
		super();
	}
	
	public Employee(Integer empno , String email, String deptno) {
		this.empno = empno ;
		this.email = email;
		this.deptno = deptno;
	}
	
	public Integer getEmpno() {
		return empno;
	}
	
	public void setEmpno(Integer empno) {
		this.empno = empno;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getDeptno() {
		return deptno;
	}
	
	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}
	
	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", email=" + email + ", deptno=" + deptno + "]";
	}
}