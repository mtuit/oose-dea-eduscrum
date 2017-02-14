package jar;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Mick on 09/02/2017.
 */
public class TrackingServiceTests {

    @BeforeClass
    public static void before() {
        System.out.println("Before Class");
    }

    @Before
    public void setUp() {
        service = new TrackingService();
    }

    @Test
    public void NewTrackingServiceTotalIsZero()
        assertEquals("Tracking service total was not zero", 1, service.getTotal());
    }

    @Test(expected = InvalidGoalException.class)
    public void WhenGoalIsSetToLessThenZeroExceptionIsThrown() throws InvalidGoalException{
        service.setGoal(-5);
    }
}
