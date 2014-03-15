package aopTestAno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		
		ApplicationContext c = new ClassPathXmlApplicationContext("aopTestAno/SpringConfigAno.xml");
		
		Wrestler w = (Wrestler) c.getBean("wrestler");
		w.pokeEyes();
		w.dropKick();
		w.pokeEyes();
		w.flipTable();
		w.saySomething("Suck it!!");
		
		Crowd cw = (Crowd)c.getBean("crowd");
		System.out.println("From crowd: "+cw.getCheer());
	}
	

}
