import java.util.Comparator;
import java.util.PriorityQueue;

public class DriverNode {
	DummyGPSLocationVar DriverCurrentLocation;
	int taxiCapacity;
	int currentCapacity;
	boolean driverState;
	PriorityQueue <UserNode> Assignments;
	
	public DriverNode(DummyGPSLocationVar location, int maxCap, int currCap, boolean status, PriorityQueue <UserNode>schedule) {
		this.DriverCurrentLocation = location;
		this.taxiCapacity = maxCap;
		this.currentCapacity = currCap;
		this.driverState = status;
		this.Assignments = schedule;
	}
	
	public DummyGPSLocationVar getDriverCurrentLocation() {
		return DriverCurrentLocation;
	}
	public void setDriverCurrentLocation(DummyGPSLocationVar driverCurrentLocation) {
		DriverCurrentLocation = driverCurrentLocation;
	}
	public int getTaxiCapacity() {
		return taxiCapacity;
	}
	public void setTaxiCapacity(int taxiCapacity) {
		this.taxiCapacity = taxiCapacity;
	}
	public int getCurrentCapacity() {
		return currentCapacity;
	}
	public void setCurrentCapacity(int currentCapacity) {
		this.currentCapacity = currentCapacity;
	}
	public boolean driverState() {
		return driverState;
	}
	public void setDriverState(boolean driverState) {
		this.driverState = driverState;
	}
	public PriorityQueue getAssignments() {
		return Assignments;
	}
	public void setAssignments(PriorityQueue assignments) {
		Assignments = assignments;
	}
	
}
