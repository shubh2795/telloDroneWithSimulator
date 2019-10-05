package Commands;

import org.junit.Test;

import static org.junit.Assert.*;

public class RightTest {

    @Test
    public void getCommand() {
        int x = 50;
        String NewCommand=(new StringBuilder()).append(TelloCommandValues.Right).append(" ").append(x).toString();
        assertEquals(NewCommand,"right 50");
    }
}