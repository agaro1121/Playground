package beanScope;

public class Test2 {
	private static int count = 0;
	
	public Test2(){
		count++;
		System.out.println("Count is (should always increase): " + count);
	}
}
