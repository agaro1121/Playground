package springCollections;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext c = new ClassPathXmlApplicationContext("SpringConfig.xml");
		CollectionTest t = (CollectionTest)c.getBean("collectionTest");
		
		System.out.println("\n-------------- LIST ---------------");
		List<String> l = t.getNames();
		for (String string : l) {
			System.out.println(string);
		}
		System.out.println("\n-------------- MAP ---------------");
		Map<String,String> h =t.getHoods();
		for (Map.Entry<String, String> entry : h.entrySet()) {
			System.out.println("Key: "+entry.getKey()+". Value = "+entry.getValue());
		}
		System.out.println("\n-------------- SET ---------------");
		Set<String> s = t.getStores();
		for (String string : s) {
			System.out.println(string);
		}
		
	}

}
