package enums;

class CoffeeTest1 {   
	   public static void main(String[] args) {
	      Coffee drink = new Coffee();
	      drink.size = CoffeeSize.BIG;        // enum outside class
	      drink.size = CoffeeSize.OVERWHELMING;
	      System.out.println(drink.size.getOunces());
	      
	   }
	}