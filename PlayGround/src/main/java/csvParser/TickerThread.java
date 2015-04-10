package csvParser;

public class TickerThread extends Thread {
	private Stock_GUI view;
	private boolean isAlive;
	private int timeInterval;
	
	public TickerThread(Stock_GUI view){
		this.view = view;
		this.isAlive = true;
	}
	
	public void setTime(int input){
		if(input > 0){
		this.timeInterval = input;
		}
	}
	
	public void run(){
		
		while(isAlive){
			try {				
				view.display();
				Thread.sleep(1000*60*timeInterval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
