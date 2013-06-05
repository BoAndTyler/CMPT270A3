

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

// do not need this now.	
//	public Event generateNextEvent(){
//		return new Event();
//	}
	
	/**
	 * Retrieving the type of event.
	 * @return the type of event
	 */
	public String getEventType(){
		return eventType;
	}
	
	/**
	 * Retrieving the time that an event took place at.
	 * @return the clock time the event took place at.
	 */
	public int getClockTime() {
		return eventClockTime;
	}
//	public String getPrintTime(int inTime){
//		int Hour;
//		int Minute;
//		int Second;
//		Hour = inTime/3600;
//		Minute = (inTime - Hour*3600)/60;
//		Second = inTime - Hour*3600 - Minute*60;
//		return Hour+":"+Minute+":"+Second;
//	}
}
