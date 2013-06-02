import linearstructures.OrdDllist;



public class EventNode extends OrdDllist{
	private Event info;
	EventNode prevDlist;
	EventNode nextDlist;
//	boolean amEmpty;
	
	
	 public EventNode() {
	        super();
	        amEmpty = true;
	        info = null;
	    }
//	 public boolean isEmpty() {
//	        return (amEmpty);
//	    }
	 public String traverseList() {
		    // add current content to list returned by the rest of the list
		    if (this.isEmpty()){
		        return "";
		    }
		    if (this.nextDlist.isEmpty()){
		        return this.info.getClockTime()+"-"+this.info.getEventType()+"\n";
		    }
		    return this.info.getClockTime()+"-"+this.info.getEventType()+"\n"+this.nextDlist.traverseList();
		}
	 public String traverseListFromStart() {
		 	if (!this.prevDlist.isEmpty())
		 		return this.prevDlist.traverseListFromStart();
		    // add current content to list returned by the rest of the list
		    if (this.isEmpty()){
		        return "";
		    }
		    if (this.nextDlist.isEmpty()){
		        return this.info.getClockTime()+"-"+this.info.getEventType()+"\n";
		    }
		    return this.info.getClockTime()+"-"+this.info.getEventType()+"\n"+this.nextDlist.traverseList();
		}
	 
	 public EventNode eventInsert(Event inEvent) {
	        if (this.isEmpty()) {
	            info = inEvent;
	            // am I at right end?
	            if (nextDlist == null) {
	                // right end empty insert
	                nextDlist = new EventNode();
	                nextDlist.prevDlist = this;    
	            }
	            // am I at left end?
	            if (prevDlist == null) {
	                // right end empty insert
	                prevDlist = new EventNode();
	                prevDlist.nextDlist = this;    
	            }
	            amEmpty = false;
	   		 	
	            return (this);
	        }
	        // insert to left?
	        
	        
	        if (this.info.getClockTime() > (inEvent.getClockTime())) {
	            return (this.prevDlist.eventInsert(inEvent));
	        }
	        
	        // insert between us? Next list can not be empty...
	        if (!(this.nextDlist.isEmpty())) {
	          if (this.nextDlist.info.getClockTime() > (inEvent.getClockTime())) {
	            // insert between
	        	  EventNode tempDlist = new EventNode();
	            tempDlist.eventInsert(inEvent);
	            tempDlist.prevDlist = this;
	            tempDlist.nextDlist = this.nextDlist;
	            this.nextDlist.prevDlist = tempDlist;
	            this.nextDlist = tempDlist;
	            return (this); 
	           }
	        }
	        // later in list
	        this.nextDlist.eventInsert(inEvent);
	        return(this);
	                
	    }
	 public static void main(String[] args) {
		 
		 System.out.println("test start");
		 EventNode testEventNode = new EventNode();
		 Event tempEvent;
		 tempEvent = new Event("getting up", 225);
		 System.out.println("event1 made.");
		 System.out.println(tempEvent.getEventType()+", "+tempEvent.getClockTime());
		 
		 testEventNode.eventInsert(tempEvent);

		 tempEvent = new Event("have breakfast", 290);
		 testEventNode.eventInsert(tempEvent);

		 tempEvent = new Event("sleeping", 210);
		 testEventNode.eventInsert(tempEvent);

		 tempEvent = new Event("take cloth on", 250);
		 testEventNode.eventInsert(tempEvent);


		 
		 System.out.println(testEventNode.traverseListFromStart());
	 }
}
