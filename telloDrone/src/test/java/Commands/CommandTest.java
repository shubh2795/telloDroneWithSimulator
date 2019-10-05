package Commands;

import org.junit.Test;

import static org.junit.Assert.*;

public class CommandTest {

    @Test
    public void getCommand() {
    String command= Command.getCommand();
    assertEquals("command",command);
    }
}