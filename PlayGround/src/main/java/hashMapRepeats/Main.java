package hashMapRepeats;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		Map<String,Integer> m = new HashMap<String,Integer>();
		String[] s = {"abc","def","ghi","abc","ghi","abc"}; 
		for (String string : s) {
			if(m.containsKey(string)){
				m.put(string, m.get(string)+1);
			}else{
				m.put(string, 1);
			}
		}
		for (Map.Entry<String,Integer> entry : m.entrySet()){
			System.out.println("Key: " + entry.getKey() + " Value = " + entry.getValue());
		}
	}

}
