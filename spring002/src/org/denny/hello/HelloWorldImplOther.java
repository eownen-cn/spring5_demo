package org.denny.hello;

public class HelloWorldImplOther {
	private HelloWorldImpl helloWorldImpl ;
	public void setHelloWorldImpl(HelloWorldImpl helloWorldImpl) {
		this.helloWorldImpl = helloWorldImpl;
	}
	@Override
	public String toString() {
		return helloWorldImpl.getData();
	}
}
