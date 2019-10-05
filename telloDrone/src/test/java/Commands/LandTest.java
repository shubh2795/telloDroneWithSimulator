package Commands;

import org.junit.Test;

import static org.junit.Assert.*;

public class LandTest {

    @Test
    public void getCommand() {
        String land= Land.getCommand();
        assertEquals("land",land);
    }
}