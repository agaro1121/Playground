package aopTestOne;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext c = new ClassPathXmlApplicationContext("SpringConfig.xml");
		Wrestler w = (Wrestler)c.getBean("wrestler");
		Crowd cw = (Crowd)c.getBean("crowd");
		w.pokeEyes();
		w.flipTable();
		w.dropKick();
		w.saySomething("fuck u");
		System.out.println("From Crowd: "+cw.getCheer());
	}

}
