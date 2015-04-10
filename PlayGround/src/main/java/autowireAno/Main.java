package autowireAno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

//		Person p = new Person(); //WILL NOT WORK MUST USE SPRING BREAN
		ApplicationContext c = new ClassPathXmlApplicationContext("SpringConfig.xml");
		Person p = (Person) c.getBean("person");
		
		System.out.println("Couch size: " + p.getCouch().getSize());
		System.out.println("Number of Legs: " + p.getDiningSet().getChairs());
		System.out.println("Dining Set size: " + p.getDiningSet().getSize());
		
		
	}

}
