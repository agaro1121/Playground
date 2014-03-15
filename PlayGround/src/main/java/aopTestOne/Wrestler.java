package aopTestOne;

public class Wrestler {
	private String cheer;
	
	public void pokeEyes(){
		System.out.println("Wrestler: Eye Gouges!");
	}
	
	public void flipTable(){
		System.out.println("Wrestler: Lambda ! *Flips table*");
	}
	
	public void dropKick(){
		System.out.println("Wrestler: DropKick biatch!");
	}
	
	public void saySomething(String cheer){
		this.cheer=cheer;
	}

	public String getCheer() {
		return cheer;
	}
	
}
