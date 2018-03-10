package org.denny.bean.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * 配置静态工厂类
 * 性质：无需生成本类实例，但可以通过本类中的有参或无参静态方法得到目标对象
 * @author Ewonen-PC
 *
 */
public class BeanStaticFactory {
	
	/**
	 * 目标对象的数据集，这里使用Map数据结构
	 */
	public static Map<String,Car> carMap = new HashMap<>() ;
	
	/**
	 * 初始化目标对象
	 */
	static {
		carMap.put("audi", new Car("AUDI", 360000)) ;
		carMap.put("ford", new Car("FORD", 250000)) ;
	}
	
	/**
	 * 静态工厂方法
	 * @param carName
	 * @return
	 */
	public static Car getCar(String carName) {
		return carMap.get(carName) ;
	}
	
}
