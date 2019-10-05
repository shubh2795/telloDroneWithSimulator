package Commands;

import org.junit.Test;

import static org.junit.Assert.*;

public class CurrentBatteryTest {

    @Test
    public void getCommand() {
        String battery= CurrentBattery.getCommand();
        assertEquals("battery?",battery);
    }
}