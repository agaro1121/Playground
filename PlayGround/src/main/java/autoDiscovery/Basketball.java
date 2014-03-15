package autoDiscovery;

import org.springframework.stereotype.Component;

@Component
public class Basketball implements Ball {
	private String size = "BIG";

	public String getSize() {
		// TODO Auto-generated method stub
		return size;
	}
}
