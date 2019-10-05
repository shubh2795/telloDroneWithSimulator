package Commands;

import org.junit.Test;

import static org.junit.Assert.*;

public class ForwardTest {

    @Test
    public void getCommand() {
        int x = 50;
        String NewCommand=(new StringBuilder()).append(TelloCommandValues.Forward).append(" ").append(x).toString();
        assertEquals(NewCommand,"forward 50");
    }
}