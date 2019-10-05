package Commands;

import org.junit.Test;

import static org.junit.Assert.*;

public class SerialTest {

    @Test
    public void getCommand() {
        String serial= Serial.getCommand();
        assertEquals("sn?",serial);
    }
}