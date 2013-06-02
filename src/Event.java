

public class Event {
	String eventType = null;
	int eventClockTime = 0;
	
	public Event() {
		eventType = null;
		eventClockTime = 0;
	}
	//The constructor with parameters
	Event(String inType,int inClockTime){
		eventType = inType;
		eventClockTime = inClockTime;
	}
	
	//TODO-finish this generator
	public Event generateNextEvent(){
		return new Event();
	}
	
	public String getEventType(){
		return eventType;
	}
	
	public int getClockTime() {
		return eventClockTime;
	}
}
