package aopTestAno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Crowd {
	private String cheer;
	
	@After("!execution(* aopTestAno.Wrestler.pokeEyes(..))")//AFTER WRESTLER DOES ANYTHING EXCEPT POKE EYES
	public void clap(){
		System.out.println("Crowd: CLAP CLAP CLAP");
	}
	
	@After("execution(* aopTestAno.Wrestler.pokeEyes(..))")
	public void boo(){
		System.out.println("Crowd: BOOOOOOO!!!!");
	}
	
	@Before("execution(* aopTestAno.Wrestler.*(..))")//BEFORE WRESTLER DOES ANY MOVE
	public void aah(){
		System.out.println("Crowd: AHHHHHHHHH!!!");
	}
	
	@After("execution(* aopTestAno.Wrestler.dropKick(..))")
	public void yea(){
		System.out.println("Crowd: YEAAAAAA BITCH!!");
	}
	
	@Around("execution(* aopTestAno.Wrestler.flipTable(..))")
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
	
	@Before("execution(* aopTestAno.Wrestler.saySomething(..)) and args(cheer)")
	public void repeat(String cheer){
		this.cheer=cheer;
	}

	public String getCheer() {
		return cheer;
	}
}
