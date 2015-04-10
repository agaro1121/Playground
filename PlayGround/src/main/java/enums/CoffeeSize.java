package enums;

public enum CoffeeSize {
	 BIG(6), 
	 HUGE(12), 
	 OVERWHELMING(18);
	 
	 
	 private int ounces;
	 CoffeeSize(int ounces){
		 this.ounces = ounces;
	 }
	public int getOunces() {
		return ounces;
	}
	
	 
}
