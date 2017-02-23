package nl.ica.oose;

import org.junit.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by Mick on 16/02/2017.
 */
public class TerugTellerTest {
    public TerugTeller sut;

    @Before
    public void setUp() throws Exception {
        sut = new TerugTeller();
    }

    @Test
    public void testGetValue() throws Exception {
        sut.setValue(10);
        assertEquals(sut.getValue(),10);
    }

    @Test
    public void testDecrement() throws Exception {
        sut.setValue(10);
        sut.decrement();
        assertEquals(sut.getValue(),9);
    }
}
