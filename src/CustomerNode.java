import linearstructures.LinkedList;

/**
 * 
 * @author Bo Dong and Tyler Spink
 *
 */
public class CustomerNode extends LinkedList
{
	Customer info;
	CustomerNode nextList;
	
	/**
	 * Adds a new customer to the end of the queue.
	 * @param inInfo the info to be inserted
	 */
    public void Join(Customer inInfo) {
        // Join(info): info becomes the end of the QUEUE the last item inserted
        this.insertInfo(inInfo);
    }
    
    /**
     * Inserts the customer info at the end of the queue.
     * @param inInfo the info to be inserted
     */
	 public void insertInfo(Customer inInfo) 
	 {
        if (this.amEmpty) 
        {
            CustomerNode tempLList = new CustomerNode();
            // insert info here and add a new empty at end
            info = inInfo;
            nextList = tempLList;
            amEmpty = false;
        }
        else 
        {    
            this.nextList.insertInfo(this.info);
            this.info = inInfo;   
        }
    }
	 
	 /**
	  * Removes the customer from the start of the queue.
	  * @return the first customer in the queue or nothing if it is empty.
	  */
	    public Customer Leave() 
	    {
	     // info <-- Leave(): if the queue is empty nothing is returned
	     //                 if the queue is not empty the last item in the list is returned and removed from the queue
	        if (this.isEmpty()) 
	        { 
	        	return null;
	        }
	        // if last item in list return and remove else leave from rest of queue
	        Customer tempCustomer;
	        
	        if (this.nextList.isEmpty()) 
	        {
	            tempCustomer = this.info;
	            this.deleteInfo(tempCustomer);
	        }  
	        else 
	        {
	            // get from later in list
	            tempCustomer = this.nextList.Leave();
	        }
	        
	        return tempCustomer;
	    }
	    
	    
	    /**
	     * Finds and deletes the info for the customer to be removed from the queue.
	     * @param outInfo info to be deleted
	     */
	    public void deleteInfo(Customer outInfo) 
	    {
	        if (this.amEmpty)
	            return;
	  
	        // check if this is the info to delete
	        if (this.info != outInfo) {
	                // System.out.println("Didn't match so looking further down list");
	                this.nextList.deleteInfo(outInfo);
	                return;
	        } 
	        // found it so delete it
	        if (this.nextList.isEmpty()) {
	                this.nextList = null;
	                this.info = null;
	                amEmpty = true;
	                // System.out.println("Deleting from last element");
	        }
	        else {
	                this.info = this.nextList.info; // copy next info to current
	                this.nextList.deleteInfo(this.info);
	                // System.out.println("Shifted info forward and deleting down rest of list");
	            }
	        }
	    
	   /**
	    * Outputs the current customers in the queue in order to the console.
	    * @return the order of the customers currently in the queue.
	    */
	    public String traverseList() 
	    {
	        // add current content to list returned by the rest of the list
	        if (this.isEmpty())
	            return "";
	        if (this.nextList.isEmpty())
	            return "Number:"+this.info.getNum()+" Time Join Queue:"+this.info.getTimeJoindQueue();
	        
	        return "Number:"+this.info.getNum()+" Time Join Queue:"+this.info.getTimeJoindQueue()+", "+this.nextList.traverseList();
	    }
	    
	    /**
	     * Test used to verify functionality of CustomerNode class.
	     */
	    public static void main(String[] args) 
	    {
			CustomerNode aCustomerNode = new CustomerNode();
			Customer temp;
			temp = new Customer();
			temp.setCustomerNumber(85);
			aCustomerNode.Join(temp);
			
			temp = new Customer();
			temp.setCustomerNumber(433);
			aCustomerNode.Join(temp);
			
			temp = new Customer();
			temp.setCustomerNumber(957);
			aCustomerNode.Join(temp);
			
			System.out.println(aCustomerNode.traverseList());
			
			System.out.println(aCustomerNode.Leave().getNum());
			System.out.println(aCustomerNode.traverseList());
			
			System.out.println(aCustomerNode.Leave().getNum());
			System.out.println(aCustomerNode.traverseList());
		}
}
