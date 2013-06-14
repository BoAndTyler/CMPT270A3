import java.util.Random;

/**
 * 
 * @author Bo Dong and Tyler Spink
 *
 */
public class Window 
{
	String info= null;
	Customer currentCustomer = null;
	CustomerQ currentQ = null;
	int windowClock = 0;
	Window nextWindow = null;
	int windowCounter = 0;
	int totalWaitingTime = 0;
	int maxWaitingTime = 0;
	EventQ theEventList = null;

	/**
	 * Links queues together.
	 * @param AQ customer queue to be linked
	 */
	public void linkQ(CustomerQ AQ)
	{
		currentQ = AQ;
	}
	
	/**
	 * Finds next available window and removes next customer from the queue to be processed.
	 */
	public void nextCustomer()
	{	
		if(currentCustomer != null)	// Check to see if there is a customer
		{
			DoJob();	// Find next customer
			nextCustomer();	// Process next customer
		}
		else
		{
			Window firstOpenWindow = this;
			
			if(currentQ.nextCustomerQ == null)	// Only one queue (Simulation #2)
			{
				firstOpenWindow = findNextWindow();	// Sets next available window
				firstOpenWindow.currentCustomer = firstOpenWindow.currentQ.leave(currentCustomer);	// Remove customer from queue
				
				if(firstOpenWindow.currentCustomer.getTimeJoindQueue() > windowClock)	
				{
					windowClock = firstOpenWindow.currentCustomer.getTimeJoindQueue();	// Adjusts the clock to match the customer
				}
				
				firstOpenWindow.DoJob();	// Process the customer
			}
			else // More than one queue (Simulation #1)
			{		
				currentCustomer = currentQ.leave(currentCustomer);	// Remove customer from queue
				
				if(firstOpenWindow.currentCustomer.getTimeJoindQueue() > windowClock)	
				{
					windowClock = firstOpenWindow.currentCustomer.getTimeJoindQueue();	// Adjusts the clock to match the customer
				}
				
				firstOpenWindow.DoJob();	// Process the customer
			}
		}
	}
	
	
	/**
	 * Finds the first available window for the customer to go to.
	 * @return a pointer to the next open window for a customer to occupy.
	 */
	public Window findNextWindow()
	{
		Window firstOpenWindow = this;
		Window travWindow = this;
		
		while(travWindow.nextWindow != null)	// Traverse through all windows
		{
			// Checks to see if the next window clock is less than the current window clock
			if(travWindow.windowClock < firstOpenWindow.windowClock)
			{
				firstOpenWindow = travWindow;	// Sets window to one with lowest clock time
			}
			travWindow = travWindow.nextWindow;	// Check next window
		}
		
		if(travWindow.windowClock < firstOpenWindow.windowClock)
		{
			// Checks to see if the last window clock is less than the current window clock
			firstOpenWindow = travWindow;
		}
		
		return firstOpenWindow;
	}
	
	/**
	 * Does the job of setting the clock and creating a new event when the customer 
	 * reaches the window and after they have been served.
	 */
	public void DoJob() {
		if(null == currentCustomer)	// Check to see if there is a customer
		{
			nextCustomer();	// Find next customer
			DoJob();	// Process next customer
		} 
		else 
		{	
			if(currentQ.nextCustomerQ == null)	// Only one queue (Simulation #2)
			{
				if(currentCustomer.getTimeJoindQueue() > windowClock)	
				{
					windowClock = currentCustomer.getTimeJoindQueue();	// Adjusts the clock to match the customer
				}
				
				currentCustomer.SetTimeToWindow(windowClock);	// Sets time stamp for when customer reaches the window
				
				Event newEvent = new Event("Customer " + currentCustomer.getNum() + " at the window"+ " (" + info + ")", windowClock);
				theEventList.eventInsert(newEvent);	// Inserts a new event when the customer reaches the window
				
				windowClock += servingTime();	// Increments the clock time with the time it takes to serve a customer
				currentCustomer.setTimeToLeave(windowClock);	// Sets time stamp for when customer leaves the window
				
				newEvent = new Event("Customer " + currentCustomer.getNum() + " leave.", windowClock);
				theEventList.eventInsert(newEvent);	// Inserts a new event when the customer is leaving
				
				currentCustomer.customerWaitingTime = currentCustomer.getTimeToWindow() - currentCustomer.getTimeJoindQueue();
				totalWaitingTime += currentCustomer.customerWaitingTime;	// Records the total time waited by the customers
				
				if(maxWaitingTime < currentCustomer.customerWaitingTime)
				{
					maxWaitingTime = currentCustomer.customerWaitingTime;	// Records the max wait time for a customer in the queue
				}
				
				currentCustomer = null;	// Remove the customer from the window
				windowCounter++;	// Counts the number of customers served
			}
			else// More than one queue (Simulation #1)
			{	
				if(currentCustomer.getTimeJoindQueue() > windowClock)	
				{
					windowClock = currentCustomer.getTimeJoindQueue();	// Adjusts the clock to match the customer
				}
				
				currentCustomer.SetTimeToWindow(windowClock);	// Sets time stamp for when customer reaches the window
				
				Event newEvent = new Event("Customer " + currentCustomer.getNum() + " at the window"+ " (" + info + ")", windowClock);				
				theEventList.eventInsert(newEvent);	// Inserts a new event when the customer reaches the window
				
				windowClock += servingTime();	// Increments the clock time with the time it takes to serve a customer
				currentCustomer.setTimeToLeave(windowClock);	// Sets time stamp for when customer leaves the window
				
				newEvent = new Event("Customer " + currentCustomer.getNum() + " leave.", windowClock);
				theEventList.eventInsert(newEvent);	// Inserts a new event when the customer is leaving
				
				currentCustomer.customerWaitingTime = currentCustomer.getTimeToWindow() - currentCustomer.getTimeJoindQueue();
				totalWaitingTime += currentCustomer.customerWaitingTime;	// Records the total time waited by the customers
				
				if(maxWaitingTime < currentCustomer.customerWaitingTime)
				{
					maxWaitingTime = currentCustomer.customerWaitingTime;	// Records the max wait time for a customer in the queue
				}
				
				currentCustomer = null;	// Remove the customer from the window
				windowCounter++;	// Counts the number of customers served
			}
		}
	}
	
	/**
	 * Calculates the amount of time it takes to serve a customer.
	 * @return a random integer in the range of 2 minutes +/- 65 seconds.
	 */
	public int servingTime()
	{	
		final int MAX = 66;		// Upper limit is exclusive
		final int MIN = -65;	// Lower limit is inclusive

		int waitTime = randomTime(MIN, MAX);
		waitTime += 120;	// Adds 2 minutes to +/- 65 seconds
		
		return waitTime;
	}
	
	/**
	 * Calculates a random number between the MIN and MAX values.
	 * @param MIN the lower limit (inclusive)
	 * @param MAX the upper limit (exclusive)
	 * @return the integer value between MIN and MAX.
	 */
	public int randomTime(int MIN, int MAX)
	{
		Random rand = new Random();
		
		int randTime = rand.nextInt(MAX - MIN) + MIN;	// Generates random numbers between MIN and MAX
		
		return randTime;
	}
	
	/**
	 * Test used to verify functionality of Window class for Simulation #1.
	 */
//	public static void main(String[] args) 
//	{
//		//make a room with 2 queue.
//		DoorKeeper aDoorKeeper = new DoorKeeper();
//		EventQ theEventQ = new EventQ();
//		aDoorKeeper.theEventList = theEventQ;
//		aDoorKeeper.firstQ = new CustomerQ();
//		aDoorKeeper.firstQ.nextCustomerQ = new CustomerQ();
//		
//		Window win1 = new Window();
//		win1.info = "1";
//		Window win2 = new Window();
//		win2.info = "2";
//		win1.nextWindow = win2;
//		win1.currentQ = aDoorKeeper.firstQ;
//		win2.currentQ = aDoorKeeper.firstQ.nextCustomerQ;
//		win1.theEventList = theEventQ;
//		win2.theEventList = theEventQ;
//		
//		while(aDoorKeeper.DoorClock<21600)
//		{
//			aDoorKeeper.CustomerComeIn();
//		}
//		while(win1.windowClock < 21600 && win2.windowClock < 21600)
//		{
//			win1.nextCustomer();
//			win2.nextCustomer();	
//		}
//		
//		//System.out.println(aDoorKeeper.firstQ.head.traverseList());
//		//System.out.println(aDoorKeeper.firstQ.nextCustomerQ.head.traverseList());
//		System.out.println(theEventQ.head.traverseListFromStart());
//	}
	
	/**
	 * Test used to verify functionality of Window class for Simulation #2.
	 */
	public static void main(String[] args) 
	{
		//make a room with 1 queue.
		DoorKeeper aDoorKeeper = new DoorKeeper();
		EventQ theEventQ = new EventQ();
		aDoorKeeper.theEventList = theEventQ;
		aDoorKeeper.firstQ = new CustomerQ();
		
		Window win1 = new Window();
		win1.info = "1";
		Window win2 = new Window();
		win2.info = "2";
		win1.nextWindow = win2;
		win1.currentQ = aDoorKeeper.firstQ;
		win2.currentQ = aDoorKeeper.firstQ;
		win1.theEventList = theEventQ;
		win2.theEventList = theEventQ;
		
		while(aDoorKeeper.DoorClock<21600){
			aDoorKeeper.CustomerComeIn();
		}
		while(win1.windowClock < 21600)
		{
			win1.nextCustomer();
		}
		
		//System.out.println(aDoorKeeper.firstQ.head.traverseList());
		//System.out.println(aDoorKeeper.firstQ.nextCustomerQ.head.traverseList());
		System.out.println(theEventQ.head.traverseListFromStart());
	}
}
