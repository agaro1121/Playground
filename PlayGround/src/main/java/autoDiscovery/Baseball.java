package autoDiscovery;

import org.springframework.stereotype.Component;

@Component
public class Baseball implements Ball {
	private String size = "small";

	public String getSize() {
		return size;
	}
}
