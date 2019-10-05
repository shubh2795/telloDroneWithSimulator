package Commands;

import org.junit.Test;

import static org.junit.Assert.*;

public class SdkTest {

    @Test
    public void getCommand() {
        String sdk= Sdk.getCommand();
        assertEquals("sdk?",sdk);
    }
}