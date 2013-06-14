/**
 * 
 * @author Bo Dong and Tyler Spink
 *
 */
public class Customer 
{
	private int timeJoindQueue = 0;
	private int timeToWindow = 0;
	private int timeToLeave = 0;
	private int customerNumber = 0;
	int customerWaitingTime = 0;
	
	/**
	 * Sets the time that a new group of customers join the queue.
	 * @param inTime the time when the next group arrives.
	 */
	public void SetTimeJoinQ(int inTime){
		timeJoindQueue = inTime;
	}

	/**
	 * Sets the time that it will take the customer to reach the front of the queue.
	 * @param inTime the time it will take to reach the front of the queue
	 */
	public void SetTimeToWindow(int inTime){
		timeToWindow = inTime;
	}
	
	/**
	 * Sets the time when a customer leaves the queue.
	 * @param inTime the time when a customer leaves
	 */
	public void setTimeToLeave(int inTime){
		timeToLeave = inTime;
	}
	
	/**
	 * Sets the number assigned to a customer
	 * @param inNum the customer number
	 */
	public void setCustomerNumber(int inNum){
		customerNumber = inNum;
	}
	
	/**
	 * Retrieves the time a group of customers joined the queue.
	 * @return the time a customer joined the queue.
	 */
	public int getTimeJoindQueue() {
		return timeJoindQueue;
	}
	
	/**
	 * Retrieves the time that it will take a customer to reach the front of the queue.
	 * @return the time for a customer to reach the front of the queue.
	 */
	public int getTimeToWindow(){
		return timeToWindow;
	}
	
	/**
	 * Retrieves the time when a customer leaves the queue.
	 * @return the time a customer leaves the queue.
	 */
	public int getTimeToLeave(){
		return timeToLeave;
	}
	
	/**
	 * Retrieves the number assigned to a customer.
	 * @return the customer number.
	 */
	public int getNum() {
		return customerNumber;
	}
}
