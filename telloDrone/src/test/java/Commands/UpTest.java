package Commands;

import Commands.Command;
import Commands.TelloCommandValues;
import org.junit.Test;

import static org.junit.Assert.*;

public class UpTest {

    @Test
    public void getCommand() {
        int x = 50;
        String NewCommand=(new StringBuilder()).append(TelloCommandValues.Up).append(" ").append(x).toString();
        assertEquals(NewCommand,"up 50");
    }
}