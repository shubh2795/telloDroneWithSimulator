package Commands;

import org.junit.Test;

import static org.junit.Assert.*;

public class DownTest {

    @Test
    public void getCommand() {
        int x = 50;
        String NewCommand=(new StringBuilder()).append(TelloCommandValues.Down).append(" ").append(x).toString();
        assertEquals(NewCommand,"down 50");
    }
}