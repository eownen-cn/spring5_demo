package org.denny.hello;

public class HelloWorldImpl implements IHelloWorld {

	private String data ;
	
	@Override
	public void setData(String data) {
		this.data = data ;
	}

	@Override
	public String getData() {
		return "Hello " + this.data ;
	}

}
