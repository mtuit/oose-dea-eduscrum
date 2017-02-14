package nl.ica.oose.dea;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * Created by Mick on 13/02/2017.
 */
public class AmdahlTest {

    private Amdahl sut;

    @Before
    public void startUp() {
        sut = new Amdahl();
    }

    @Test
    public void CalculateSpeedupFactor() throws IllegalArgumentException {
        assertEquals(3.0, sut.CalculateSpeedupFactor(4, 0.1), 0.1);
    }

    @Test
    public void CalculateEfficiency() throws IllegalArgumentException {
        assertEquals(0.75, sut.CalculateEfficiency(sut.CalculateSpeedupFactor(4, 0.1), 4), 0.1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestIllegalArgumentExceptionCalculateSpeedupFactor () throws IllegalArgumentException {
        sut.CalculateSpeedupFactor(-1, 1.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestIllegalArgumentExceptionCalculateEfficiency() throws IllegalArgumentException {
        sut.CalculateEfficiency(-1.0, 1);
    }

}