package verbalizeNumbers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;


public class NumberConverter {

	public static String convertNumberToWord(String input){
		StringBuilder number = new StringBuilder();
		BigInteger userInput = new BigInteger(input);
		BigInteger quintillion = new BigInteger("1000000000000000000");
		if(userInput.compareTo(quintillion) >= 0) return "Number to big";
		BigInteger quadrillion = new BigInteger("1000000000000000");
		BigInteger trillion = new BigInteger("1000000000000");
		BigInteger billion =  new BigInteger("1000000000");
		BigInteger million =  new BigInteger("1000000");
		BigInteger thousand = new BigInteger("1000");
		
		number.append(getString(userInput.mod(quintillion).divide(quadrillion).intValue(), "quadrillion"));
		number.append(getString(userInput.mod(quadrillion).divide(trillion).intValue(), "trillion"));
		number.append(getString(userInput.mod(trillion).divide(billion).intValue(), "billion"));
		number.append(getString(userInput.mod(billion).divide(million).intValue(),"million"));
		number.append(getString(userInput.mod(million).divide(thousand).intValue(),"thousand"));
		number.append(getString(userInput.mod(thousand).intValue(),"hundred"));
		return number.toString();
	}
	
	private static StringBuilder getString(int number, String place){
		Properties numberWords = new Properties();
		FileInputStream xmlFile;
		try {
			xmlFile = new FileInputStream("src/main/java/verbalizeNumbers/NumberWords.xml");
			numberWords.loadFromXML(xmlFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		StringBuilder numberString = new StringBuilder();
		numberString.setLength(0);
		
		if( number > 0){
			if(number/100 > 0) numberString.append(numberWords.get(String.valueOf(number/100)) + " hundred ");
			if(number%100/10 > 1) numberString.append(numberWords.get(String.valueOf(number%100 - number%10)) + " " + numberWords.get(String.valueOf(number%10)));
				else if(number%100/10 == 1) numberString.append(numberWords.get(String.valueOf(number%100)));
				else numberString.append(numberWords.getProperty(String.valueOf(number%10)));
			if(!place.equals("hundred")) numberString.append(" " + place + ", ");
			numberString.append("\n");
		}
		return numberString;
	}
}
