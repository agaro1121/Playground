package autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext c = new ClassPathXmlApplicationContext("SpringConfig.xml");
//		ApplicationContext c = new FileSystemXmlApplicationContext("src/main/java/autowire/SpringConfig.xml");
		Car car = (Car)c.getBean("car");
		
		System.out.println(car.getC().getCol());
		System.out.println(car.getS().getDoors());
	}

}
