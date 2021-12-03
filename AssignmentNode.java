import java.util.ArrayList;

public class AssignmentNode {
	DriverNode assignedDriver;
	UserNode assignedUser;
	ArrayList <UserNode> assignedUsers;
	
	public AssignmentNode(DriverNode driver, UserNode user) {
		this.assignedDriver = driver;
		this.assignedUser = user;
		//this.assignedUsers = users;
	}

	public DriverNode getAssignedDriver() {
		return assignedDriver;
	}

	public void setAssignedDriver(DriverNode assignedDriver) {
		this.assignedDriver = assignedDriver;
	}

	public UserNode getAssignedUser() {
		return assignedUser;
	}

	public void setAssignedUser(UserNode assignedUser) {
		this.assignedUser = assignedUser;
	}

	public ArrayList<UserNode> getAssignedUsers() {
		return assignedUsers;
	}

	public void setAssignedUsers(ArrayList<UserNode> assignedUsers) {
		this.assignedUsers = assignedUsers;
	}
	
}
