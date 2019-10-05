package Commands;

import org.junit.Test;

import static org.junit.Assert.*;

public class FlipTest {

    @Test
    public void getCommand() {
        String x = "r";
        String NewCommand=(new StringBuilder()).append(TelloCommandValues.Flip).append(" ").append(x).toString();
        assertEquals(NewCommand,"flip r");
    }
}