
public class CustomerQ {
	CustomerNode head= null;
	int length = 0;
	int maxlength = 0;
	CustomerQ nextCustomerQ = null;
	
	
	
	/**
	 * Adds a new customer to the end of the queue.
	 * @param inInfo the new customer to be added to the queue
	 */
	public void join(Customer inInfo){
		if (head == null) {//check if head is empty?
			CustomerNode tempCustomerNode = new CustomerNode();//if empty, build a new.
			head = tempCustomerNode;
		}
		//insert customer inInfo into the queue.
		head.Join(inInfo);
		length = length+1;
		if (length>maxlength) {//add the queue length.
			maxlength = length;
		}
	}
	
	/**
	 * Removes the customer from the start of the queue.
	 * @param outInfo the customer to be removed from the start of the queue
	 * @return the first customer in the queue or nothing if it is empty.
	 */
	public Customer leave(Customer outInfo){
		if (length>0) {
			length = length -1;
			return head.Leave();
		}else{
		return null;
		}
	}
	
	/**
	 * Retrieves the number of customers in the queue.
	 * @return the current amount of customers in the queue.
	 */
	public int getLength(){
		return length;
	}
	
	/**
	 * Retrieves the maximum number of customers waiting in the queue.
	 * @return the maximum amount of customers in the queue at one time.
	 */
	public int getMaxLength(){
		return maxlength;
	}
	
	
}
