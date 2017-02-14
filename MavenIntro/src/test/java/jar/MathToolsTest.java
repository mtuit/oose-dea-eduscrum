package jar;

import jar.MathTools;

import org.junit.Test;
import static org.junit.Assert.*;

public class MathToolsTest {
    
    @Test
    public void positieveGetallen() {
        MathTools m = new MathTools();
        int maxResult = MathTools.max(1, 2, 3);
        assertEquals(3, maxResult);
    }
    
    @Test
    public void negatieveGetallen() {
        MathTools m = new MathTools();
        int maxResult = m.max(-1, -2, -3);
        assertEquals(-1, maxResult);
    }
}
