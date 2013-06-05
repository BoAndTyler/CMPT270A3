


public class DoorKeeper {
	CustomerQ firstQ= null;
	CustomerQ shortestQ = null;
	int DoorClock= 0;
	int customerCounter= 0;
	EventQ theEventList = null;
	//TODO throw event need to be done.
	
	
	
	
	//post: change firstQ if there is no queue in room,
	//		shortestQ will be checked , may be changed.
	//		DoorClock will go  1 minute ± 50 seconds.
	//		new group customers will be created and throw into queue.
	
	public void CustomerComeIn(){
	//A new customer group arrives every 1 minute ± 50 seconds 
		timePassedWhenCustomerComeIn();
		
		
	//create new group of customers.
		int customerNumber;
		double randomSeed;
		randomSeed = Math.random();
		if (randomSeed>=0 && randomSeed<= 0.3) {
			customerNumber = 1;
		} else if (randomSeed>0.3 && randomSeed<= 0.7) {
			customerNumber = 2;
		} else if (randomSeed>0.7 && randomSeed<= 0.9) {
			customerNumber = 3;
		} else if (randomSeed>0.9 && randomSeed<= 0.95) {
			customerNumber = 4;
		} else if (randomSeed>0.95 && randomSeed<= 0.98){
			customerNumber = 5;
		} else{
			customerNumber = 6;
		}
		//for test
		//System.out.println(customerNumber+"\n");
		
		checkShortestQ();// and it can build new queue if there is no queue.
		
		//join group into the queue.
		for (int i = 0; i < customerNumber; i++) {
			
			Customer newCustomer = new Customer();//create a new customer;
			
			customerCounter =customerCounter+1;// counter go for 1;
			newCustomer.setCustomerNumber(customerCounter);
			newCustomer.SetTimeJoinQ(DoorClock);//tell customer the time he or she come in.
			shortestQ.join(newCustomer);// let them join the shortest queue.
			
			Event newEvent = new Event("New Customer in,number:"+newCustomer.getNum(),DoorClock);
			theEventList.eventInsert(newEvent);
			//create a new event about new customer, 
			//and add it into eventQ;
		}

	}
	
	
	
	//post: will check and may change the shorstestQ. 
	public void checkShortestQ(){
		if (null == firstQ) {//if there is no queue in the room
			firstQ = new CustomerQ();//build one.
			shortestQ = firstQ;
			
		}else if (null == firstQ.nextCustomerQ) {//if only one queue in the room
			shortestQ = firstQ;//it is the shortest.
			
		}else if (null == shortestQ) {
			shortestQ = firstQ;
		} else {
			CustomerQ travQ = firstQ;
			while (travQ!=null) {//if there are still queues not been traversed 
				if (travQ.length < shortestQ.length) {//check length ,if shorter than our shortest q,
					shortestQ = travQ;//update shortest q.
				}
				travQ = travQ.nextCustomerQ;	
			}
		}
	}
	
	
	//post: will add time into DoorClock.
	public void timePassedWhenCustomerComeIn() {
		//A new customer group arrives every 1 minute ± 50 seconds 
		int timeAdd =(int) (Math.random())*(110-10)+10;
		DoorClock = DoorClock+timeAdd;
	}
	
	//test
	public static void main(String[] args) {
		//make a room with 2 queue.
		DoorKeeper aDoorKeeper = new DoorKeeper();
		EventQ theEventQ = new EventQ();
		aDoorKeeper.theEventList = theEventQ;
		aDoorKeeper.firstQ = new CustomerQ();
		aDoorKeeper.firstQ.nextCustomerQ = new CustomerQ();
		while(aDoorKeeper.DoorClock<21600){
		aDoorKeeper.CustomerComeIn();
		}
		System.out.println(aDoorKeeper.firstQ.head.traverseList());
		System.out.println(aDoorKeeper.firstQ.nextCustomerQ.head.traverseList());
		
		
	}
	
	
}
