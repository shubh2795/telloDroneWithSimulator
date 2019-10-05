package Commands;

import org.junit.Test;

import static org.junit.Assert.*;

public class CwTest {

    @Test
    public void getCommand() {
        int x = 50;
        String NewCommand=(new StringBuilder()).append(TelloCommandValues.Cw).append(" ").append(x).toString();
        assertEquals(NewCommand,"cw 50");
    }
}