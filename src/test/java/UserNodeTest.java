import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserNodeTest {

    UserNode user;
    @BeforeEach
    void setUp(){
        user = new UserNode("Harold", new DummyGPSLocationVar(), new DummyGPSLocationVar(), false, false, false);
    }

    @Test
    void distanceFromDriverCost() {
        assertEquals(0, user.distanceFromDriverCost(new DummyGPSLocationVar()));
    }

    @Test
    void userCost() {
        assertEquals(50, user.UserCost(new DummyGPSLocationVar()));
    }
}