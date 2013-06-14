import linearstructures.OrdDllist;

/**
 * 
 * @author Bo Dong and Tyler Spink
 *
 */
public class EventNode extends OrdDllist
{
	Event info;
	EventNode prevDlist;
	EventNode nextDlist;
//	boolean amEmpty;
	
	 public EventNode() 
	 {
        super();
        amEmpty = true;
        info = null;
	 }
	 
//	 public boolean isEmpty() 
//	 {
//	 	return (amEmpty);
//	 }
	 
	 /**
	  * Outputs the events list from the last event in order to the console.
	  * @return the list of events in order from the last event
	  */
	 public String traverseList() 
	 {
	    // add current content to list returned by the rest of the list
	    if (this.isEmpty())
	    {
	        return "";
	    }
	    
	    if (this.nextDlist.isEmpty())
	    {
	        return this.info.getPrintTime()+" - "+this.info.getEventType()+"\n";
	    }
	    
	    return this.info.getPrintTime()+" - "+this.info.getEventType()+"\n"+this.nextDlist.traverseList();
	 }
	 
	 /**
	  * Outputs the events list from the first event in order to the console.
	  * @return the list of events in order from the first event
	  */
	 public String traverseListFromStart() 
	 {
	 	if (!this.prevDlist.isEmpty())
	 	{
	 		return this.prevDlist.traverseListFromStart();
	 	}
	    // add current content to list returned by the rest of the list
	    if (this.isEmpty())
	    {
	        return "";
	    }
	    
	    if (this.nextDlist.isEmpty())
	    {
	        return this.info.getClockTime()+"-"+this.info.getEventType()+"\n";
	    }
	    
	    return this.info.getClockTime()+"-"+this.info.getEventType()+"\n"+this.nextDlist.traverseList();
	 }
	 
	 /**
	  * Outputs the events list from the first event in order to the console in a formated time.
	  * @return the list of events in order from the first event in the format hours:minutes:seconds
	  */
	 public String traverseEventTime() 
	 {
	 	if (!this.prevDlist.isEmpty())
	 	{
	 		return this.prevDlist.traverseEventTime();
	 	}
	    // add current content to list returned by the rest of the list
	    if (this.isEmpty())
	    {
	        return "";
	    }
	    
	    if (this.nextDlist.isEmpty())
	    {
	        return this.info.getPrintTime()+" - "+this.info.getEventType()+"\n";
	    }
	    
	    return this.info.getPrintTime()+" - "+this.info.getEventType()+"\n"+this.nextDlist.traverseList();
	 }
	 
	 /**
	  * Inserts the event into the event list based on its clock time.
	  * @param inEvent the event to be inserted into the list
	  * @return The location of where the event was inserted into the list.
	  */
	 public EventNode eventInsert(Event inEvent) 
	 {
        if (this.isEmpty()) 
        {
            info = inEvent;
            // am I at right end?
            if (nextDlist == null) 
            {
                // right end empty insert
                nextDlist = new EventNode();
                nextDlist.prevDlist = this;    
            }
            // am I at left end?
            if (prevDlist == null) 
            {
                // right end empty insert
                prevDlist = new EventNode();
                prevDlist.nextDlist = this;    
            }
            
            amEmpty = false;
   		 	
            return (this);
        }
        // insert to left?
        
        
        if (this.info.getClockTime() > (inEvent.getClockTime())) 
        {
            return (this.prevDlist.eventInsert(inEvent));
        }
        
        // insert between us? Next list can not be empty...
        if (!(this.nextDlist.isEmpty())) 
        {
          if (this.nextDlist.info.getClockTime() > (inEvent.getClockTime())) 
          {
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
	 
	 /**
	  * Test used to verify functionality of EventNode class.
	  */
	 public static void main(String[] args) 
	 {	 
		 System.out.println("test start");
		 EventNode testEventNode = new EventNode();
		 Event tempEvent;
		 tempEvent = new Event("getting up", 225);
		 
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
