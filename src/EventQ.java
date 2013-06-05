



public class EventQ {
	EventNode head = null;
	
	/**
	 * Inserts a new event into the event list.
	 * @param inEvent the new event to be inserted
	 */
	public void eventInsert(Event inEvent){
		if (head==null) {
			head = new EventNode();
		} 
		head.eventInsert(inEvent);
	}
	
	public void printLog(){
		
		//TODO
	}
	
}
