package Commands;

import org.junit.Test;

import static org.junit.Assert.*;

public class LeftTest {

    @Test
    public void getCommand() {
        int x = 50;
        String NewCommand=(new StringBuilder()).append(TelloCommandValues.Left).append(" ").append(x).toString();
        assertEquals(NewCommand,"left 50");
    }
}