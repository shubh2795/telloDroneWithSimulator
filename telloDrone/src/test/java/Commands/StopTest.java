package Commands;

import org.junit.Test;

import static org.junit.Assert.*;

public class StopTest {

    @Test
    public void getCommand() {
        String stop= Stop.getCommand();
        assertEquals("stop",stop);
    }
}