public class Demo {
    public static void main(String[] args) {
        RideScheduler r = new RideScheduler();
        DummyGPSLocationVar kusch = new DummyGPSLocationVar(41.500760, -81.600200);
        DummyGPSLocationVar tomlinson = new DummyGPSLocationVar(41.435060, -81.544220);
        DummyGPSLocationVar thwing = new DummyGPSLocationVar(41.551560, -81.439180);
        DummyGPSLocationVar taft = new DummyGPSLocationVar(41.512730, -81.607160);
        DriverNode driver1 = new DriverNode(kusch);
        UserNode user1 = new UserNode("Albert", tomlinson, thwing, false, false, false);
        UserNode user2 = new UserNode("Bob the Builder", thwing, taft, false, false, false);
        r.addUserRequest(user1);
        r.addUserRequest(user2);
        r.generateAssignmentQueue(driver1);
        r.deleteUserRequest(user1);
        driver1.setDriverCurrentLocation(thwing);
        r.generateAssignmentQueue(driver1);
    }
}
