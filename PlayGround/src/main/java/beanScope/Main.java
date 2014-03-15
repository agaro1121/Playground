package beanScope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext c = new ClassPathXmlApplicationContext("SpringConfig.xml");
		c.getBean("testBean");
		c.getBean("testBean");
		c.getBean("testBean");
		c.getBean("testBean");
		c.getBean("testBean");
		c.getBean("testBean");
		System.out.println();
		c.getBean("testBean2");
		c.getBean("testBean2");
		c.getBean("testBean2");
		c.getBean("testBean2");
		c.getBean("testBean2");
		
		
	}

}
