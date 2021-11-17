import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

class DriverNodeTest {

    DriverNode driver;
    PriorityQueue<UserNode> assignments;
    DummyGPSLocationVar location;
    @BeforeEach
    void setUp(){
        location = new DummyGPSLocationVar();
        assignments = new PriorityQueue<UserNode>();
        driver = new DriverNode(location, 5, 5, false, assignments);
    }

    @Test
    void getDriverCurrentLocation() {
        assertEquals(location, driver.getDriverCurrentLocation());
    }

    @Test
    void setDriverCurrentLocation() {
        DummyGPSLocationVar location2 = new DummyGPSLocationVar();
        driver.setDriverCurrentLocation(location2);
        assertEquals(location2, driver.getDriverCurrentLocation());
    }

    @Test
    void getTaxiCapacity() {
        assertEquals(5,driver.getTaxiCapacity());
    }

    @Test
    void setTaxiCapacity() {
        driver.setTaxiCapacity(3);
        assertEquals(3, driver.getTaxiCapacity());
    }

    @Test
    void getCurrentCapacity() {
        assertEquals(5, driver.getCurrentCapacity());
    }

    @Test
    void setCurrentCapacity() {
        driver.setCurrentCapacity(3);
        assertEquals(3, driver.getCurrentCapacity());
    }

    @Test
    void driverState() {
        assertEquals(false, driver.driverState());
    }

    @Test
    void setDriverState() {
        driver.setDriverState(true);
        assertEquals(true, driver.driverState());
    }

    @Test
    void getAssignments() {
        assertEquals(assignments, driver.getAssignments());
    }

    @Test
    void setAssignments() {
        driver.setAssignments(null);
        assertNull(driver.getAssignments());
    }
}