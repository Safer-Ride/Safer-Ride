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
    void setAndGetUserID(){
        user.setUserID("Joseph");
        assertEquals("Joseph", user.getUserID());
    }

    @Test
    void setAccepted(){
        user.setAccepted(true);
        assertEquals(true, user.isAccepted());
    }

    @Test
    void setCarpool(){
        user.setCarpool(true);
        assertEquals(true, user.isCarpool());
    }

    @Test
    void setEventRequest(){
        user.setEventRequest(true);
        assertEquals(true, user.isEventRequest());
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