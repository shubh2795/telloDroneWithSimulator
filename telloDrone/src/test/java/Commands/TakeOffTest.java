package Commands;

import org.junit.Test;

import static org.junit.Assert.*;

public class TakeOffTest {

    @Test
    public void getCommand() {
        String takeoff= TakeOff.getCommand();
        assertEquals("takeoff",takeoff);

    }
}