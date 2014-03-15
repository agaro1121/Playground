package autowire;

public class Car {
	private Color c;
	private Sedan s;
	public Color getC() {
		return c;
	}
	public Sedan getS() {
		return s;
	}
	public void setC(Color c) {
		this.c = c;
	}
	public void setS(Sedan s) {
		this.s = s;
	}
}
