package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Pattern p = Pattern.compile("[{]\\d+[}]");
		Matcher m = p.matcher("{1}{2}adf34{10}");
		
		while(m.find()){
			System.out.println(m.start()+" "+m.group());
		}
	}

}
