/**
 * 
 * @author Bo Dong and Tyler Spink
 *
 */
public class Simulation1 
{	
	public static void main(String[] args) 
	{	
		final int SIMUTIME = 21600;
			
		//make a room with 2 queue.
		DoorKeeper aDoorKeeper = new DoorKeeper();
		EventQ theEventQ = new EventQ();
		theEventQ.SIMUTIME = SIMUTIME;
		aDoorKeeper.theEventList = theEventQ;
		aDoorKeeper.firstQ = new CustomerQ();
		aDoorKeeper.firstQ.nextCustomerQ = new CustomerQ();
		
		Window win1 = new Window();
		win1.info = "1";
		Window win2 = new Window();
		win2.info = "2";
		win1.nextWindow = win2;
		win1.currentQ = aDoorKeeper.firstQ;
		win2.currentQ = aDoorKeeper.firstQ.nextCustomerQ;
		win1.theEventList = theEventQ;
		win2.theEventList = theEventQ;
		
		while(aDoorKeeper.DoorClock<SIMUTIME)
		{
			aDoorKeeper.CustomerComeIn();
		}
		
		while(win1.windowClock < SIMUTIME && win2.windowClock < SIMUTIME)
		{
			win1.nextCustomer();	
			win2.nextCustomer();
		}
		
		//System.out.println(aDoorKeeper.firstQ.head.traverseList());
		//System.out.println(aDoorKeeper.firstQ.nextCustomerQ.head.traverseList());
		System.out.println("Simulation #1 - 2 Windows 2 Queues");
		System.out.println(theEventQ.head.traverseEventTime());
		
		int MaxCustomerServed = win1.windowCounter + win2.windowCounter;
		System.out.println("Maximum number of customers served: "+MaxCustomerServed );
		
		System.out.println("Average number of customers severed by window 1:  "+ win1.windowCounter/6 +" /hour.");
		System.out.println("Average number of customers severed by window 2:  "+ win2.windowCounter/6 +" /hour.");
		
		int totalWaitingTime = win1.totalWaitingTime+win2.totalWaitingTime;
		System.out.println("Average wait time in the queue for each customer is: "+ totalWaitingTime/MaxCustomerServed +" sec." );
		
		System.out.println("Maximum waiting time for window 1:  "+ win1.maxWaitingTime +" sec." );
		System.out.println("Maximum waiting time for window 2:  "+ win2.maxWaitingTime +" sec." );
		
		System.out.println("Maximum queue length for window 1:  "+ win1.currentQ.maxlength +" people." );
		System.out.println("Maximum queue length for window 2:  "+ win2.currentQ.maxlength +" people." );
		
		System.out.println("Average  queue length per hour is: "+ theEventQ.AverageQueueLengthPerHour() +" people." );
	}
}
