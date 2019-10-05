package Commands;

import org.junit.Test;

import static org.junit.Assert.*;

public class EnableVideoStreamTest {

    @Test
    public void getCommand() {
        String videoStream= EnableVideoStream.getCommand();
        assertEquals("streamon",videoStream);
    }
}