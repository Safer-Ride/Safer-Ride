import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.*;

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
				/*if (child.UserCost(driver.getDriverCurrentLocation()) <= nodesInQueue.UserCost(driver.getDriverCurrentLocation())) {
					return (1); 
				}
				else if (child.UserCost(driver.getDriverCurrentLocation()) >= nodesInQueue.UserCost(driver.getDriverCurrentLocation())) {
					return (-1); 
				}
				else
					return (0); */
				return Integer.compare(child.distanceFromDriverCost(driver.DriverCurrentLocation), nodesInQueue.distanceFromDriverCost(driver.DriverCurrentLocation));
			}			
		};
		PriorityQueue<UserNode> uniqueAssignments = new PriorityQueue<UserNode>(50,CostComparator);
		for (int i = 0; i < userRequests.size(); i++) {
			uniqueAssignments.add(userRequests.get(i));
		}
		driver.setAssignments(uniqueAssignments);
		UserNode[] arr = uniqueAssignments.toArray(new UserNode[uniqueAssignments.size()]);
		if (arr[0] != null) {
			System.out.println(arr[0].UserID + ": ETA of " + arr[0].distanceFromDriverCost(driver.getDriverCurrentLocation()) / 60 + " minutes");
		}
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
	
	public static void main(String[] args) {
		//initializes the wait time costs for all the users in queue
		for (int i = 0; i < RideScheduler.userRequests.size(); i++) {
			RideScheduler.updateWaitTimeCost(userRequests.get(i));
		}
	}
	
}
