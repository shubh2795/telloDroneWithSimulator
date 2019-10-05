package Missions;

import Commands.Flip;
import Commands.Left;
import org.junit.Test;

import static org.junit.Assert.*;

public class Mission3Test {

    @Test
    public void sendOtherCommands() {
        String[] droneCommand = { Flip.getCommand(), Left.getCommand() };
        String [] testCommand= {"command","left"};
        assertEquals(testCommand[0],droneCommand[0]);

    }
}