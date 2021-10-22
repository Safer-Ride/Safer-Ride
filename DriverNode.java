import java.util.PriorityQueue;

public class DriverNode {
	DummyGPSLocationVar DriverCurrentLocation;
	int taxiCapacity;
	int currentCapacity;
	boolean isIdle;
	PriorityQueue Assignments;
	
	
	public DriverNode(DummyGPSLocationVar location, int maxCap, int currCap, boolean status, PriorityQueue schedule) {
		this.DriverCurrentLocation = location;
		this.taxiCapacity = maxCap;
		this.currentCapacity = currCap;
		this.isIdle = status;
		this.Assignments = schedule;
	}
	
	//Driver Commands 
		//NextAssignment
		//PreviousAssignment
		//Generate newAssingmentQueue 
		//StartAssignment
		//EndAssigment
	
	//Driver
	

}
