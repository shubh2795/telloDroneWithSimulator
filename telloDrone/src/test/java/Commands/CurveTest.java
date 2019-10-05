package Commands;

import org.junit.Test;

import static org.junit.Assert.*;

public class CurveTest {

    @Test
    public void getCommand() {
        String curve= Curve.getCommand();
        assertEquals("curve",curve);
    }
}