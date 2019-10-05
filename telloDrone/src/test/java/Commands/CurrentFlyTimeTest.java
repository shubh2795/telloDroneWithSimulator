package Commands;

import org.junit.Test;

import static org.junit.Assert.*;

public class CurrentFlyTimeTest {

    @Test
    public void getCommand() {
    String flyTime= CurrentFlyTime.getCommand();
    assertEquals("time?",flyTime);
    }
}