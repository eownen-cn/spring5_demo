package org.denny.bean.annotation;

public abstract class BaseObject{
	protected String data = this.getClass().getName();

	public String toString() {
		return "TestObject [data=" + this.data + "]";
	}
}