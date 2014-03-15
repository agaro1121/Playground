package aopTestOne;

import org.aspectj.lang.ProceedingJoinPoint;

public class Crowd {
	private String cheer;
	public void clap(){
		System.out.println("Crowd: CLAP CLAP CLAP");
	}
	
	public void boo(){
		System.out.println("Crowd: BOOOOOOO!!!!");
	}
	
	public void aah(){
		System.out.println("Crowd: AHHHHHHHHH!!!");
	}
	
	public void yea(){
		System.out.println("Crowd: YEAAAAAA BITCH!!");
	}
	
	public void fullReaction(ProceedingJoinPoint jp){
		try {
			System.out.print("Around: ");
			aah();
			jp.proceed();
			System.out.print("Around: ");
			yea();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void repeat(String cheer){
		this.cheer=cheer;
	}

	public String getCheer() {
		return cheer;
	}
}
