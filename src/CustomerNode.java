import linearstructures.LinkedList;



public class CustomerNode extends LinkedList{
	Customer info;
	CustomerNode nextList;
	
    public void Join(Customer inInfo) {
        // Join(info): info becomes the end of the QUEUE the last item inserted
          this.insertInfo(inInfo);
    }
	 public void insertInfo(Customer inInfo) {
	        if (this.amEmpty) {
	            CustomerNode tempLList = new CustomerNode();
	            // insert info here and add a new empty at end
	            info = inInfo;
	            nextList = tempLList;
	            amEmpty = false;
	        }
	        else {
	            
	            this.nextList.insertInfo(this.info);
	            this.info = inInfo;
	            
	        }
	    }
	    public Customer Leave() {
	     // info <-- Leave(): if the queue is empty nothing is returned
	     //                 if the queue is not empty the last item in the list is returned and removed from the queue
	        if (this.isEmpty()) { 
	        	return null;
	        }
	        // if last item in list return and remove else leave from rest of queue
	        Customer tempCustomer;
	        if (this.nextList.isEmpty()) {
	            tempCustomer = this.info;
	            this.deleteInfo(tempCustomer);
	        }  else {
	            // get from later in list
	            tempCustomer = this.nextList.Leave();
	        }
	        return tempCustomer;
	    }
	    
	    
	    
	    public void deleteInfo(Customer outInfo) {
	        if (this.amEmpty)
	            return;
	  
	        // check if this is the info to delete
	        if (this.info != outInfo) {
//	                System.out.println("Didn't match so looking further down list");
	                this.nextList.deleteInfo(outInfo);
	                return;
	        } 
	        // found it so delete it
	        if (this.nextList.isEmpty()) {
	                this.nextList = null;
	                this.info = null;
	                amEmpty = true;
//	                System.out.println("Deleting from last element");
	        }
	        else {
	                this.info = this.nextList.info; // copy next info to current
	                this.nextList.deleteInfo(this.info);
//	                System.out.println("Shifted info forward and deleting down rest of list");
	            }
	        }
	    public String traverseList() {
	        // add current content to list returned by the rest of the list
	        if (this.isEmpty())
	            return "";
	        if (this.nextList.isEmpty())
	            return "Number:"+this.info.getNum();
	        
	        return "Number:"+this.info.getNum()+", "+this.nextList.traverseList();
	    }
	    public static void main(String[] args) {
			CustomerNode aCustomerNode = new CustomerNode();
			Customer temp;
			temp = new Customer();
			temp.setCustomerNumber(885);
			aCustomerNode.Join(temp);
			
			temp = new Customer();
			temp.setCustomerNumber(433);
			aCustomerNode.Join(temp);
			
			temp = new Customer();
			temp.setCustomerNumber(257);
			aCustomerNode.Join(temp);
			
			System.out.println(aCustomerNode.traverseList());
			
			aCustomerNode.Leave();
			System.out.println(aCustomerNode.traverseList());
			aCustomerNode.Leave();
			System.out.println(aCustomerNode.traverseList());
			
		}
}
