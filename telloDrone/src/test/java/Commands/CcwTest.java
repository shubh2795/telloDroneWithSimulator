package Commands;

import org.junit.Test;

import static org.junit.Assert.*;

public class CcwTest {

    @Test
    public void getCommand() {
        int x = 50;
        String NewCommand=(new StringBuilder()).append(TelloCommandValues.Ccw).append(" ").append(x).toString();
        assertEquals(NewCommand,"ccw 50");
    }
}