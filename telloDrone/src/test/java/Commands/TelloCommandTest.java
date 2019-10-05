package Commands;

import org.junit.Test;

import static org.junit.Assert.*;

public class TelloCommandTest {

    @Test
    public void getCommand() {
        String string = TelloCommand.getCommand();
        assertEquals(" ",string);
    }
}