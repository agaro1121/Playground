package autoDiscovery;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext c = new ClassPathXmlApplicationContext("SpringConfig.xml");
//		TeenBoy t = (TeenBoy)c.getBean("guy"); //NORMAL
		TeenBoy t = (TeenBoy)c.getBean("teenBoy"); //AUTODISCOVERY METHOD - CLASS ID SET USING CAMEL CASE
		System.out.println(t.getBall().getSize());
		System.out.println(t.getBall2().getSize());
	}

}
