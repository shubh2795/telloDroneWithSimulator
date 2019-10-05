package Commands;

import org.junit.Test;

import static org.junit.Assert.*;

public class SpeedTest {

    @Test
    public void getCommand() {
        String speed= Speed.getCommand();
        assertEquals("speed",speed);
    }
}