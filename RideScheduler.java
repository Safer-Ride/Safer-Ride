import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class RideScheduler {

	PriorityQueue<UserNode> assignments;
	Comparator<UserNode> CostComparator;
	HashSet<UserNode> completedAssignments = new HashSet <UserNode>();
	
	//generates a queue based on the driver 
	public PriorityQueue generateAssignmentQueue (DriverNode driver) {
		return assignments;
	}
	
	//addtoqueue
	//delete
}
