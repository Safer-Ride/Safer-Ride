import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class RideScheduler extends TimeBoundCosts{


	//Comparator<UserNode> CostComparator;
	public static ArrayList <UserNode> userRequests = new ArrayList <UserNode>();
	ArrayList<DriverNode> allDrivers = new ArrayList <DriverNode>();
	HashSet<AssignmentNode> completedAssignments = new HashSet <AssignmentNode>();
	
	//generates a queue based on the driver 
	public void generateAssignmentQueue (DriverNode driver) {
		//for all user nodes in list we need to generate user cost with the location of driver and user 
		Comparator<UserNode> CostComparator= new Comparator<UserNode>() {
			@Override
			public int compare(UserNode child, UserNode nodesInQueue) { 
				if (child.userAssignmentCost(driver.getDriverCurrentLocation()) <= nodesInQueue.userAssignmentCost(driver.getDriverCurrentLocation())) {
					return (1); 
				}
				else if (child.userAssignmentCost(driver.getDriverCurrentLocation()) >= nodesInQueue.userAssignmentCost(driver.getDriverCurrentLocation())) {
					return (-1); 
				}
				else
					return (0); 
			}			
		};
		PriorityQueue<UserNode> uniqueAssignments = new PriorityQueue<UserNode>(50,CostComparator);
		for (int i = 0; i < userRequests.size(); i++) {
			uniqueAssignments.add(userRequests.get(i));
		}
		driver.setAssignments(uniqueAssignments);
	}
	
	
	public ArrayList<UserNode> getUserRequests() {
		return userRequests;
	}


	public void setUserRequests(ArrayList<UserNode> userRequests) {
		this.userRequests = userRequests;
	}


	public void updatesDriverQueues () {
		for (int i = 0; i < allDrivers.size(); i++) {
			generateAssignmentQueue(allDrivers.get(i));
		}
	}
	
	public void addUserRequest (UserNode request) {
		for (int i = 0; i < allDrivers.size(); i++) {
			//add user node to all driver nodes 
			allDrivers.get(i).getAssignments().add(request);
		}
		//add user node to user requests array
		userRequests.add(request);
	}
	
	public void deleteUserRequest (UserNode request) {
		for (int i = 0; i < allDrivers.size(); i++) {
			//add user node to all driver nodes 
			allDrivers.get(i).getAssignments().remove(request);
		}
	}
	
	public AssignmentNode acceptAssignment (DriverNode driver, UserNode user) {
		//change current state of the user node to isaccepted
		user.setAccepted(true);
		//change the driver node to 
		driver.setDriverState(true);
		//delete user request from all queues
		this.deleteUserRequest(user);
		//create an assignment with the Driver node and User Node 
		AssignmentNode assignment = new AssignmentNode(driver, user);
		return assignment;
	}
	
	public void completedAssignment (AssignmentNode completedAssignment) {
		//takes the user node out of queue
		userRequests.remove(completedAssignment.getAssignedUser());
		//changes state of Driver to false
		completedAssignment.getAssignedDriver().setDriverState(false);
		//stored the assignment in a hashmap 
		completedAssignments.add(completedAssignment);
	}
	
	public void addDriver(DriverNode driverToAdd) {
		this.allDrivers.add(driverToAdd);
	}

	public static void wait(int ms){
    try
    	{
        Thread.sleep(ms);
    	}
    catch(InterruptedException ex)
    	{
        Thread.currentThread().interrupt();
    	}
	}
	/**
	 * String id, DummyGPSLocationVar start, DummyGPSLocationVar end,
			boolean isShared, boolean forEvent, boolean isAcc 
	 * 
	 */
	
	public static void main(String[] args) {
		RideScheduler demoRideScheduler = new RideScheduler();
		//kusch
		DummyGPSLocationVar user1_startlocation = new DummyGPSLocationVar(41.500760, -81.600200);
		//tomilson
		DummyGPSLocationVar user2_startlocation = new DummyGPSLocationVar(41.435060, -81.544220);
		
		DummyGPSLocationVar user1_endlocation = new DummyGPSLocationVar(41.500760, -81.600200);
		DummyGPSLocationVar user2_endlocation = new DummyGPSLocationVar(41.435060, -81.544220);

		//thwing
		DummyGPSLocationVar driver_location = new DummyGPSLocationVar(41.551560, -81.439180); 

		UserNode node1 = new UserNode("kusch node" , user1_startlocation, user1_endlocation, false, false, false);
		UserNode node2 = new UserNode("tomilson node", user2_startlocation, user2_endlocation, false,false,false);
		DriverNode dnode = new DriverNode(driver_location);
		//add these nodes to the userRequests 
		RideScheduler.userRequests.add(node1);
		RideScheduler.userRequests.add(node2);

		demoRideScheduler.generateAssignmentQueue(dnode);
		//initializes the wait time costs for all the users in queue
		for (int i = 0; i < RideScheduler.userRequests.size(); i++) {
			RideScheduler.updateWaitTimeCost(userRequests.get(i));
		}

		node1.userAssignmentCost(driver_location);
		node2.userAssignmentCost(driver_location);

		System.out.println("this is the priority queue with two nodes");


		//immediate cost after initalization:
		System.out.println("these are the initial costs of both user nodes: " );
		System.out.println("User1 cost: " + node1.userAssignmentCost(driver_location));
		System.out.println("User2 cost: " + node2.userAssignmentCost(driver_location));

		//after 10 seconds:
		//RideScheduler.wait(10000);
		//immediate cost after delay:
		System.out.println("these are the  costs after 10 sec both user nodes: " );
		System.out.println("User1 cost: " + node1.userAssignmentCost(driver_location));
		System.out.println("User2 cost: " + node2.userAssignmentCost(driver_location));

		//prints out the pq in correct order of cost: 
		System.out.println("this is the size of the assignmwnts queue" + dnode.getAssignments().size());
		//dnode.getUserNodeName();
		System.exit(0);
	}
}
