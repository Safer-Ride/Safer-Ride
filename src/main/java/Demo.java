public class Demo {
    public static void main(String[] args) {
        RideScheduler r = new RideScheduler();
        DummyGPSLocationVar kusch = new DummyGPSLocationVar(41.500760, -81.600200);
        DummyGPSLocationVar tomlinson = new DummyGPSLocationVar(41.435060, -81.544220);
        DummyGPSLocationVar thwing = new DummyGPSLocationVar(41.551560, -81.439180);
        DriverNode driver1 = new DriverNode(kusch);
        UserNode user1 = new UserNode("Albert", tomlinson, thwing, false, false, false);
        r.addUserRequest(user1);
        r.generateAssignmentQueue(driver1);
    }
}
