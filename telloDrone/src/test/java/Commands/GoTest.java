package Commands;

import org.junit.Test;

import static org.junit.Assert.*;

public class GoTest {

    @Test
    public void getCommand() {
        String go= Go.getCommand();
        assertEquals("go",go);
    }
}