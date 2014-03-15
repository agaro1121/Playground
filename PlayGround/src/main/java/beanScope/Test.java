package beanScope;

public class Test {
	private static int count = 0;
	
	public Test(){
		count++;
		System.out.println("Count (should be 1): " + count);
	}
	
}
