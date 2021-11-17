import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Driver;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class AssignmentNodeTest {

    AssignmentNode assign;
    UserNode user;
    DriverNode driver;
    PriorityQueue<UserNode> assignments;
    @BeforeEach
    void setUp(){
        assignments = new PriorityQueue<UserNode>();
        user = new UserNode("Harold", new DummyGPSLocationVar(), new DummyGPSLocationVar(), false, false, false);
        driver = new DriverNode(new DummyGPSLocationVar(), 5, 5, false, assignments);
        assign = new AssignmentNode(driver, user);
    }

    @Test
    void getAssignedDriver() {
        assertEquals(driver, assign.getAssignedDriver());
    }

    @Test
    void setAssignedDriver() {
        DriverNode newDriver = new DriverNode(new DummyGPSLocationVar(), 4, 4, true, assignments);
        assign.setAssignedDriver(newDriver);
        assertNotEquals(driver, assign.getAssignedDriver());
    }

    @Test
    void getAssignedUser() {
        assertEquals(assign.getAssignedUser(), user);
    }

    @Test
    void setAssignedUser() {
        UserNode newUser = new UserNode("Johnny", new DummyGPSLocationVar(), new DummyGPSLocationVar(), false, false, false);
        assign.setAssignedUser(newUser);
        assertNotEquals(user, assign.getAssignedUser());
    }

}