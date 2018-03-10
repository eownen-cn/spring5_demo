package org.denny.bean.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * 实例工厂方法
 * @author Ewonen-PC
 *
 */
public class BeanInstanceFactory {
	private Map<String,Car> carMap = null ;

	public BeanInstanceFactory() {
		carMap = new HashMap<>() ;
		carMap.put("audi",new Car("AUDI", 360000)) ;
		carMap.put("ford",new Car("FORD", 180000)) ;
	}
	public Car getCar(Object carName) {
		return carMap.get(carName) ;
	}
	
}
