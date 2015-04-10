package autoDiscovery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TeenBoy {
	@Autowired
	private Baseball ball;
	
	@Autowired
	private Basketball ball2;

	public Ball getBall() {
		return ball;
	}

	public Ball getBall2() {
		return ball2;
	}
}
