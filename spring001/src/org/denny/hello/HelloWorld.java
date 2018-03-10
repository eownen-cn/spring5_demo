package org.denny.hello;

public class HelloWorld implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private String data ;
	private int data2 ;
	private double data3 ;
	private float data4 ;
	private long data5 ;
	
	public void setData(String data) {
		this.data = data;
	}
	public void print() {
		System.out.println("Hello " + this.data );
		System.out.println("Hello " + this.data2 );
		System.out.println("Hello " + this.data3 );
		System.out.println("Hello " + this.data4 );
		System.out.println("Hello " + this.data5 );
	}
	public HelloWorld() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HelloWorld(String data,int data2,double data3,float data4,long data5) {
		super();
		this.data = data;
		this.data2 = data2 ;
		this.data3 = data3 ;
		this.data4 = data4 ;
		this.data5 = data5 ;
		System.out.println(data);
		System.out.println(data2);
		System.out.println(data3);
		System.out.println(data4);
		System.out.println(data5);
	}
	
	public HelloWorld(int data2,double data3,float data4,long data5,String data) {
		super();
		this.data = data;
		this.data2 = data2 ;
		this.data3 = data3 ;
		this.data4 = data4 ;
		this.data5 = data5 ;
		System.out.println(data2);
		System.out.println(data3);
		System.out.println(data4);
		System.out.println(data5);
		System.out.println(data);
	}
	
}
