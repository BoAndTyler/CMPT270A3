/**
 * 
 * @author Bo Dong and Tyler Spink
 *
 */
public class EventQ 
{
	EventNode head = null;
	int SIMUTIME = 0;
	
	/**
	 * Inserts a new event into the event list.
	 * @param inEvent the new event to be inserted
	 */
	public void eventInsert(Event inEvent)
	{
		if (head==null)
		{
			head = new EventNode();
		}
		
		head.eventInsert(inEvent);
	}
	
	/**
	 * Finds the average length of the queue per hour.
	 * @return the average length of a queue.
	 */
	public int AverageQueueLengthPerHour()
	{
		if (head==null) 
		{
			head = new EventNode();
		}
		
		EventNode travNode = this.head;
		
		int qLengthAverage=0;
		int qLengthThishour =0;
		int temp = 0;
		
		for(int i = 0; i < SIMUTIME/3600; i++)	// Checks data every hour
		{
			int startTime = i*3600;
			int endTime = (i+1)*3600;
			int qLengthAddedThisHour = 0;
			
			while(travNode.info.eventClockTime >=startTime &&travNode.info.eventClockTime <= endTime)
			{	
				if(travNode.info.eventType.contains("k"))	// Search for 'k' in 'walk' for customer arriving
				{
					qLengthAddedThisHour++;	// Increment queue length when a new group of customers arrive
				}
				
				if(travNode.info.eventType.contains("d"))	// Search for 'd' in 'window' for customer leaving
				{
					qLengthAddedThisHour--;	// Decrement queue length when a customer leaves
				}
				
				travNode = travNode.nextDlist;	// Check next event
			}
			
			//System.out.println(qLengthAddedThisHour);
			qLengthThishour = qLengthThishour + qLengthAddedThisHour;	// Add together queue lengths
			temp = temp + qLengthThishour;
		}
		
		qLengthAverage = temp/6;	// Divide total by simulation time to get average
		return qLengthAverage;
	}
}
