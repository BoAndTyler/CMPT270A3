
public class Customer {
	private int timeJoindQueue = 0;
	private int timeToWindow = 0;
	private int timeToLeave = 0;
	private int customerNumber = 0;
	
	public void SetTimeJoinQ(int inTime){
		timeJoindQueue = inTime;
	}

	public void SetTimeToWindow(int inTime){
		timeToWindow = inTime;
	}
	public void setTimeToLeave(int inTime){
		timeToLeave = inTime;
	}
	public void setCustomerNumber(int inNum){
		customerNumber = inNum;
	}
	
	public int getTimeJoindQueue() {
		return timeJoindQueue;
	}
	public int getTimeToWindow(){
		return timeToWindow;
	}
	public int getTimeToLeave(){
		return timeToLeave;
	}
	public int getNum() {
		return customerNumber;
	}
	
}
