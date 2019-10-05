package Commands;

import org.junit.Test;

import static org.junit.Assert.*;

public class CurrentSpeedTest {

    @Test
    public void getCommand() {
        String speed= CurrentSpeed.getCommand();
        assertEquals("speed?",speed);
    }
}