package org.denny.bean.factory;

import org.springframework.beans.factory.FactoryBean;

/**
 * Car的factoryBean工厂
 * @author Ewonen-PC
 *
 */
public class BeanFactoryBaan implements FactoryBean<Car> {

	private String brand ;
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getBrand() {
		return brand;
	}
	
	@Override
	public Car getObject() throws Exception {
		return new Car(brand,500000) ;
	}

	@Override
	public Class<?> getObjectType() {
		return Car.class ;
	}

}
