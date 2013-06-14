/**
 * 
 * @author Bo Dong and Tyler Spink
 *
 */
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

/**
 * This method is not needed as its functionality has 
 * been replaced by the classes Window and DoorKeeper
 */
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
	
	/**
	 * Converts the clock time from seconds into hours, minutes, and seconds.
	 * @return A string containing the time formated by hours:minutes:seconds.
	 */
	public String getPrintTime()
	{
		int Hour;
		int Minute;
		int Second;
		
		int inTime = getClockTime();
		
		Hour = inTime/3600;
		Minute = (inTime - Hour*3600)/60;
		Second = inTime - Hour*3600 - Minute*60;
		
		return Hour+":"+Minute+":"+Second;
	}
}
