package Commands;

import org.junit.Test;

import static org.junit.Assert.*;

public class DisableVideoStreamTest {

    @Test
    public void getCommand() {
        String videoStream= DisableVideoStream.getCommand();
        assertEquals("streamoff",videoStream);
    }
}