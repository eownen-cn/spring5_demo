package spring004;

import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * bean关系
 * 1.bean之间的继承与parent的使用
 * 2.抽象bean的应用与注意点
 * @author Ewonen-PC
 *
 */
@SuppressWarnings("resource")
public class Main {
	public static void main(String[] args) {
		Person person = (Person) new ClassPathXmlApplicationContext("relation.xml").getBean("person");
		System.out.println(person);
	}
}
