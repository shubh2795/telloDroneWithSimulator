package Commands;

import org.junit.Test;

import static org.junit.Assert.*;

public class EmergencyTest {

    @Test
    public void getCommand() {
        String command= Emergency.getCommand();
        assertEquals("emergency",command);
    }
}