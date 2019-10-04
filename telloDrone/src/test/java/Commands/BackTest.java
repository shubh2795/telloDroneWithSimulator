package Commands;

import Commands.TelloCommandValues;
import org.junit.Test;

import static org.junit.Assert.*;

public class BackTest {

    @Test
    public void getCommand() {
        int x = 50;
        String NewCommand=(new StringBuilder()).append(TelloCommandValues.Back).append(" ").append(x).toString();
        assertEquals(NewCommand,"back 50");

    }
}