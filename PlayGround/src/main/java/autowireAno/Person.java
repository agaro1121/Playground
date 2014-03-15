package autowireAno;

import org.springframework.beans.factory.annotation.Autowired;

public class Person {
	@Autowired
	private Couch couch;
	@Autowired //MUST PUT AUTOWIRE ON EACH ONE!!
	private DiningSet diningSet;
	public Couch getCouch() {
		return couch;
	}
	public DiningSet getDiningSet() {
		return diningSet;
	}
}
