
public class Window {
	Customer currentCustomer = null;
	CustomerQ currentQ = null;
	int windowClock = 0;
	Window nextWindow = null;
	EventQ theEventList = null;
	
	public void linkQ(CustomerQ AQ){
		currentQ = AQ;
	}
	
	public void nextCustomer(){
		//TODO
	}
	public void DoJob() {
		if (null == currentCustomer) {
			nextCustomer();
			DoJob();
		} else {
			//TODO
		}
	}
}
